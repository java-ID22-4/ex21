package com.example.sem18_1.controllers;

import com.example.sem18_1.services.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping
public class MainController {

    @Autowired
    private IssuedBookService issuedBookService;

    @GetMapping
    public String listIssuedBooks() {
        return "redirect:/issuedBooks";
    }
}