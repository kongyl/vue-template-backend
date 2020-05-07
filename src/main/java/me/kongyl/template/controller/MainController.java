package me.kongyl.template.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.kongyl.template.base.BaseController;
import me.kongyl.template.base.BizException;
import me.kongyl.template.base.ResMessage;
import me.kongyl.template.base.Result;
import me.kongyl.template.model.TemplateUser;
import me.kongyl.template.service.TemplateUserService;
import me.kongyl.template.util.CodeUtils;

@Controller
public class MainController extends BaseController {
    
    @Autowired
    private TemplateUserService templateUserService;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @ResponseBody
    @PostMapping("/login")
    public Result<String> login(String username, String password, Boolean isRemember, HttpServletRequest request) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            return error(ResMessage.ERROR_PARAM);
        }
        if (isRemember == null) {
            isRemember = false;
        }
        
        String userId;
        try {
            TemplateUser user = templateUserService.login(username, password);
            userId = user.getId();
        } catch (BizException exception) {
            return error(exception);
        }
        
        String token = CodeUtils.uuid();
        // token写入session
        HttpSession session = request.getSession();
        session.setAttribute("token", token);
        if (isRemember) { // 写入数据库
            templateUserService.saveToken(userId, token);
        }

        return success(token);
    }
    
}
