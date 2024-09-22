package com.example.sem18_1.controllers;

import com.example.sem18_1.services.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class MainController {

    @Autowired
    private IssuedBookService issuedBookService;

    @GetMapping
    public String listIssuedBooks() {
        return "index";
    }
}