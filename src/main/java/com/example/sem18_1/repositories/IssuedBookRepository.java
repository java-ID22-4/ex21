package com.example.sem18_1.repositories;

import com.example.sem18_1.models.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Long> {
    List<IssuedBook> findByIssueDateBetween(LocalDate startDate, LocalDate endDate);
}

