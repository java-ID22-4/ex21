package com.example.sem18_1.controllers;

import com.example.sem18_1.services.IssuedBookService;
import com.example.sem18_1.models.IssuedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/issued-books")
public class IssuedBookController {

    @Autowired
    private IssuedBookService issuedBookService;

    @GetMapping
    public String listIssuedBooks(Model model) {
        model.addAttribute("issuedBooks", issuedBookService.getAllIssuedBooks());
        return "issuedBooks";
    }

    @GetMapping("/issue")
    public String showIssueForm(Model model) {
        model.addAttribute("issuedBook", new IssuedBook());
        return "issuedBooks";
    }

    @PostMapping("/issue")
    public String issueBook(@ModelAttribute IssuedBook issuedBook) {
        issuedBook.setIssueDate(LocalDate.now());
        issuedBookService.issueBook(issuedBook);
        return "redirect:/issuedBooks";
    }

    @GetMapping("/filter")
    public String filterIssuedBooksByDate(@RequestParam("startDate") String startDate,
                                          @RequestParam("endDate") String endDate,
                                          Model model) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        model.addAttribute("issuedBooks", issuedBookService.filterByIssueDate(start, end));
        return "issuedBooks";
    }
}

