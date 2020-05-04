package me.kongyl.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.kongyl.template.base.BaseController;
import me.kongyl.template.util.CodeUtils;

@Controller
public class MainController extends BaseController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @ResponseBody
    @PostMapping("/login")
    public String login(String username, String password, Boolean isRemember) {
        String token = CodeUtils.uuid();
        return token;
    }
    
}
