package com.example.BookTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    // Méthode pour afficher la page d'inscription (GET)
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Correspond au fichier register.html
    }

    // Méthode pour gérer les soumissions de formulaire (POST)
    @PostMapping("/register")
    public String handleRegister(
        @RequestParam("username") String username,
        @RequestParam("password") String password
    ) {
        // Traitez les données ici (par ex. : enregistrer dans la base de données)
        System.out.println("Nom d'utilisateur : " + username);
        System.out.println("Mot de passe : " + password);

        // Redirige vers une autre page après soumission
        return "register-success"; // Correspond à un fichier register-success.html
    }
}
