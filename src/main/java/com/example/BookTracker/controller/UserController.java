package com.example.BookTracker.controller;

import com.example.BookTracker.entity.User;
import com.example.BookTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Affiche le formulaire d'inscription
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User()); // Initialise un nouvel objet User
        return "register"; // Retourne le fichier register.html
    }

    // Gère la soumission du formulaire d'inscription
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userRepository.save(user); // Enregistre l'utilisateur dans la base de données
        
        // Ajoutez un message de succès au modèle
        model.addAttribute("successMessage", "Inscription réussie !");
        model.addAttribute("user", new User()); // Réinitialise le formulaire pour l'utilisateur suivant
        return "register"; // Reste sur la page register.html
    }

    // Affiche le formulaire de connexion
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User()); // Initialise un nouvel objet User
        return "login"; // Retourne le fichier login.html
    }

    // Gère la soumission du formulaire de connexion
    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User existingUser = userRepository.findByUsername(user.getUsername()); // Cherche l'utilisateur par nom
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "redirect:/books"; // Redirige vers la liste des livres si connexion réussie
        }
        model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
        return "login"; // Reste sur la page login.html avec un message d'erreur
    }
}
