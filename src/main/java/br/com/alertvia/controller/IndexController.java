package br.com.alertvia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "/index";
    }

    @GetMapping("/teste")
    public String teste(){
        return "/stats";
    }
}
