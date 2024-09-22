package com.example.sem18_1.controllers;

import com.example.sem18_1.services.BookService;
import com.example.sem18_1.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "booksPage";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "booksAddPage";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model
    ) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(
            @PathVariable Long id,
            @ModelAttribute Book updatedBook
    ) {
        Book existingBook = bookService.getBookById(id);

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setPublisher(updatedBook.getPublisher());

        bookService.saveBook(existingBook);

        return "redirect:/books";
    }
}

