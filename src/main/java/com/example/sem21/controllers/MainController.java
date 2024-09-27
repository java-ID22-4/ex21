package com.example.sem21.controllers;

import com.example.sem21.services.ShippedEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class MainController {

    @Autowired
    private ShippedEquipmentService shippedEquipmentService;

    @GetMapping
    public String mainPage() {
        return "index";
    }
}