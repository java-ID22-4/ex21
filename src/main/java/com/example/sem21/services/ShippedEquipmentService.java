package com.example.sem21.services;

import com.example.sem21.models.ShippedEquipment;
import com.example.sem21.repositories.ShippedEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShippedEquipmentService {

    @Autowired
    private ShippedEquipmentRepository shippedEquipmentRepository;

    public List<ShippedEquipment> getAllShippedEquipments() {
        return shippedEquipmentRepository.findAll();
    }

    public ShippedEquipment shipEquipment(ShippedEquipment shippedEquipment) {
        return shippedEquipmentRepository.save(shippedEquipment);
    }

    public List<ShippedEquipment> filterByShipDate(LocalDate startDate, LocalDate endDate) {
        return shippedEquipmentRepository.findByShipDateBetween(startDate, endDate);
    }
}

