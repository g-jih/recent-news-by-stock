package com.gjih.recentnewsbystock.controller;
import com.gjih.recentnewsbystock.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final NewsService newsService;

    @GetMapping("/")
    public String main(Model model) {
        String news = newsService.getNews("삼성전자");
        model.addAttribute("news", news);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
