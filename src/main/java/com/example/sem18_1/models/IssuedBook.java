package com.example.sem18_1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Entity
public class IssuedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Getter
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Getter
    private LocalDate issueDate;  // Дата выдачи
    @Getter
    private LocalDate returnDate; // Дата возврата

    public IssuedBook() {}
}
