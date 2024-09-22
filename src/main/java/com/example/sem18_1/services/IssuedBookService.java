package com.example.sem18_1.services;

import com.example.sem18_1.models.IssuedBook;
import com.example.sem18_1.repositories.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IssuedBookService {

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    public List<IssuedBook> getAllIssuedBooks() {
        return issuedBookRepository.findAll();
    }

    public IssuedBook issueBook(IssuedBook issuedBook) {
        return issuedBookRepository.save(issuedBook);
    }

    public List<IssuedBook> filterByIssueDate(LocalDate startDate, LocalDate endDate) {
        return issuedBookRepository.findByIssueDateBetween(startDate, endDate);
    }
}

