package br.com.alertvia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;

@Controller
@RequestMapping("/login")
public class LoginController {


    @GetMapping
    public String login(){
        return "login/form-login";
    }

}