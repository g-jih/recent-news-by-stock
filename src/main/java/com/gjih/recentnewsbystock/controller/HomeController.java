package com.gjih.recentnewsbystock.controller;
import com.gjih.recentnewsbystock.service.NewsService;
import com.gjih.recentnewsbystock.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final NewsService newsService;
    private final StockService stockService;

    @GetMapping("/")
    public String main(Model model, @Valid String savedStock) {
        // 종목 리스트 보내기
        List<Stock> stocks = stockService.getStockList();
        model.addAttribute("stocks", stocks);

        // 관심 종목 리스트 보내기
        List<Stock> savedStocks = new ArrayList<>();
        savedStocks.add(new Stock("삼성전자", "1234"));
        savedStocks.add(new Stock("카카오", "2345"));
        savedStocks.add(new Stock("네이버", "3456"));
        savedStocks.add(new Stock("크래프톤", "4567"));
        savedStocks.get(0).setSelected(true);
        model.addAttribute("savedStocks", savedStocks);

        //log.info("선택된 주식!!!! " + savedStock);
        String selectedStock = "삼성전자";
        // 뉴스 정보 보내기
        List<NewsForm> newsList = null;
        if (selectedStock != null) {
            ApiDTO apiResponse = newsService.getNews(selectedStock);
            newsList = apiResponse.getItems();
        }
        model.addAttribute("newsList", newsList);


        // 코스피 정보 보내기


        // 코스닥 정보 보내기


        return "index";
    }

}
