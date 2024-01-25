package com.crud.rentalmobil.delivery.rest;

import com.crud.rentalmobil.model.DataUser;
import com.crud.rentalmobil.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    private final UserRepository userRepository;

    @Autowired
    public PageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String loginForm(Model model) {
        String title_web = "Login";
        model.addAttribute("title_web", title_web);
        model.addAttribute("user", new DataUser());
        return "index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute("user") DataUser dataUser, HttpSession session) {
        DataUser existingUser = userRepository.getDataUser(dataUser.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(dataUser.getPassword())) {
            session.setAttribute("loggedInUser", existingUser);
            if ("admin".equals(existingUser.getRole())) {
                return "redirect:/list-mobil";
            } else {
                return "redirect:/kasir";
            }
        }
        return "redirect:/";
    }
}
