package com.example.sem21.repositories;

import com.example.sem21.models.ShippedEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShippedEquipmentRepository extends JpaRepository<ShippedEquipment, Long> {
    List<ShippedEquipment> findByShipDateBetween(LocalDate startDate, LocalDate endDate);
}

