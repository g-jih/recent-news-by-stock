package com.gjih.recentnewsbystock.controller;

import com.gjih.recentnewsbystock.entity.Member;
import com.gjih.recentnewsbystock.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger("LoginController");
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String createRegisterForm(Model model) {
        logger.info("register GET 로그 테스트");

        model.addAttribute("registerform", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterForm registerform, BindingResult result) {

        if (result.hasErrors()) {
            return "/register";
        }

        Member member = new Member(registerform.getUsername(), registerform.getEmail(), registerform.getPassword());
        memberService.join(member);

        return "redirect:/login";
    }

    @GetMapping("/password")
    public String findPassword() {
        return "password";
    }

}
