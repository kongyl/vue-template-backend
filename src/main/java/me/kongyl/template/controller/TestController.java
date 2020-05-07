package me.kongyl.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.kongyl.template.util.CodeUtils;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/bcrypt")
    public String bcrypt() {
        return CodeUtils.bcrypt("admin");
    }
    
    @GetMapping("/bcrypt/check")
    public boolean checkBCrypt() {
        String hashed = "$2a$10$Dg9WX7XjNoDeDFyqJGy2Teq.PGdJVUjGKG8kmN2wQ22ca9nbeKwuO";
        return CodeUtils.bcryptCheck("admin", hashed);
    }
     
}
