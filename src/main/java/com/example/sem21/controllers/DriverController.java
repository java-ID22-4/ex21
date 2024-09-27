package com.example.sem21.controllers;

import com.example.sem21.models.Driver;
import com.example.sem21.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public String listDrivers(Model model) {
//        TODO: Добавить добавление атрибута кол-ва учеников
        model.addAttribute("drivers", driverService.getAllDrivers());
        return "driversPage";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("driver", new Driver());
        return "addDriverPage";
    }

    @PostMapping("/add")
    public String addDriver(@ModelAttribute Driver driver) {
        driverService.saveDriver(driver);
        return "redirect:/drivers";
    }

    @PostMapping("/delete/{id}")
    public String deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return "redirect:/drivers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model
    ) {
        Driver driver = driverService.getDriverById(id);
        model.addAttribute("driver", driver);
        return "editDriverPage";
    }

    @PostMapping("/edit/{id}")
    public String updateDriver(
            @PathVariable Long id,
            @ModelAttribute Driver updateDriver
    ) {
        Driver existingDriver = driverService.getDriverById(id);

        existingDriver.setName(updateDriver.getName());
        existingDriver.setSurname(updateDriver.getSurname());

        driverService.saveDriver(existingDriver);

        return "redirect:/drivers";
    }
}

