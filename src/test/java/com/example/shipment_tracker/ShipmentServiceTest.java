package com.example.shipment_tracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ShipmentServiceTest {

    @Autowired
    private ShipmentService shipmentService;

    @Test
    public void testShipmentServiceExists() {
        assertNotNull(shipmentService, "ShipmentService should not be null");
    }
}

