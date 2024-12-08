package com.example.shipment_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShipmentService {

    @Value("${aftership.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public ShipmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getShipmentStatus(String trackingNumber) {
        String url = "https://api.aftership.com/v4/trackings/" + trackingNumber;

        HttpHeaders headers = new HttpHeaders();
        headers.set("aftership-api-key", apiKey);
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, entity);

        return response.getBody();
    }
}
