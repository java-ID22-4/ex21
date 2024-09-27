package com.example.sem21.controllers;

import com.example.sem21.models.Equipment;
import com.example.sem21.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public String listEquipments(Model model) {
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        return "equipmentsPage";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("equipment", new Equipment());
        return "addEquipmentPage";
    }

    @PostMapping("/add")
    public String addEquipment(@ModelAttribute Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return "redirect:/equipments";
    }

    @PostMapping("/delete/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return "redirect:/equipments";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model
    ) {
        Equipment equipment = equipmentService.getEquipmentById(id);
        model.addAttribute("equipment", equipment);
        return "editEquipmentPage";
    }

    @PostMapping("/edit/{id}")
    public String updateEquipment(
            @PathVariable Long id,
            @ModelAttribute Equipment updatedEquipment
    ) {
        Equipment existingEquipment = equipmentService.getEquipmentById(id);

        existingEquipment.setType(updatedEquipment.getType());
        existingEquipment.setGroup(updatedEquipment.getGroup());

        equipmentService.saveEquipment(existingEquipment);

        return "redirect:/equipments";
    }
}

