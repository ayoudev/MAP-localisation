package com.pfa.localisation.controller;

import com.pfa.localisation.entity.users;
import com.pfa.localisation.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class VehiculeController {

    @Autowired
    private userService uService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/list_vehicule")
        public String listVehicule(){
            return "list_vehicule";
        }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/list_user")
    public ModelAndView getAllUsers() {
        List<users> list = uService.getAllUsers();
       // ModelAndView m=new ModelAndView();
       // m.setViewName("list_user");
       // m.addObject("users",list);
        return new ModelAndView("list_user","users",list);
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute users u){
        uService.save(u);
        return "redirect:/login";
    }
@RequestMapping("/deleteUser/{id}")
public String deleteUser(@PathVariable("id") int id){
    uService.deleteById(id);
        return "redirect:/list_user";
}

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestParam("mail") String mail, @RequestParam("password") String password, Model model) {
        // Vérifier les informations d'identification de l'utilisateur
        if(uService.authenticate(mail, password)) {
            // Rediriger vers la page d'accueil si les informations d'identification sont correctes
            return "redirect:/";
        } else {
            // Afficher un message d'avertissement si les informations d'identification sont incorrectes
            model.addAttribute("error", "Email ou mot de passe incorrect.");
            return "login";
        }
    }
}
