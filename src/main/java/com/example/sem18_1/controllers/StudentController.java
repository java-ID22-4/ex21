package com.example.sem18_1.controllers;

import com.example.sem18_1.models.Book;
import com.example.sem18_1.services.StudentService;
import com.example.sem18_1.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
//        TODO: Добавить добавление атрибута кол-ва учеников
        model.addAttribute("students", studentService.getAllStudents());
        return "studentsPage";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentAdd";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model
    ) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("book", student);
        return "studentEdit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(
            @PathVariable Long id,
            @ModelAttribute Book updatedBook
    ) {
        Student existingStudent = studentService.getStudentById(id);

        existingStudent.setName(updatedBook.getTitle());
        existingStudent.setSurname(updatedBook.getPublisher());

        studentService.saveStudent(existingStudent);

        return "redirect:/students";
    }
}

