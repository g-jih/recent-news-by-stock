package com.gjih.recentnewsbystock.controller;
import com.gjih.recentnewsbystock.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final NewsService newsService;

    @GetMapping("/")
    public String main(Model model) {
        ApiDTO apiResponse = newsService.getNews("삼성전자");
        List<NewsForm> newsList = apiResponse.getItems();
        model.addAttribute("newsList", newsList);
        return "index";
    }
}
