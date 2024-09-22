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


@Getter
@Setter
@Entity
public class IssuedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    private LocalDate issueDate;  // Дата выдачи
    private LocalDate returnDate; // Дата возврата

    public IssuedBook() {}
}
