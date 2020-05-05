package me.kongyl.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.kongyl.template.util.CodeUtils;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/bcrypt")
    public boolean checkBCrypt() {
        String hashed = "$2a$10$TPylsEwRgTY2suLthNs/9eo8oY4FOp0MjKUDGQbMq.Q7POEzA/iSG";
        return CodeUtils.bcryptCheck(CodeUtils.bcrypt("admin"), hashed);
    }
    
}
