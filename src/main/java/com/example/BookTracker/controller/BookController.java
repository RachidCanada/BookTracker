package com.example.BookTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/book-list")
    public String showBookListPage(Model model) {
        // Exemple : Ajouter des livres fictifs pour tester l'affichage
        model.addAttribute("books", new String[]{"Book 1", "Book 2", "Book 3"});
        return "book-list"; // Correspond au fichier book-list.html
    }

    @GetMapping("/book-form")
    public String showBookFormPage() {
        return "book-form"; // Correspond au fichier book-form.html
    }
}
