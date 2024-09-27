package com.example.sem21.controllers;

import com.example.sem21.services.ShippedEquipmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/shipped-equipments")
public class ShippedEquipmentController {

    @Autowired
    private ShippedEquipmentService shippedEquipmentService;

    @GetMapping
    public String listShippedEquipments(Model model) {
        model.addAttribute("shippedEquipments", shippedEquipmentService.getAllShippedEquipments());
        return "shippedEquipmentsPage";
    }

    @GetMapping("/filter")
    public String filterShippedEquipmentsByDate(@RequestParam("startDate") String startDate,
                                                @RequestParam("endDate") String endDate,
                                                Model model) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        model.addAttribute("shippedEquipments", shippedEquipmentService.filterByShipDate(start, end));
        return "shippedEquipmentsPage";
    }
}

