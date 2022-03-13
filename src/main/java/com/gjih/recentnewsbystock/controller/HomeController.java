package com.gjih.recentnewsbystock.controller;
import com.gjih.recentnewsbystock.entity.Stock;
import com.gjih.recentnewsbystock.service.NewsService;
import com.gjih.recentnewsbystock.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final NewsService newsService;
    private final StockService stockService;

    @GetMapping("/")
    public String main(Model model, @Valid String stock) {
        // 종목 리스트 보내기
        List<StockItem> stockList = getStockList();
        model.addAttribute("stockList", stockList);

        // 관심 종목 리스트 보내기
        List<Stock> savedStocks = stockService.findAll();
        model.addAttribute("savedStocks", savedStocks);

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


        return "home";
    }

    private final Logger logger = LoggerFactory.getLogger("StockService");
    public static List<StockItem> getStockList() {
        List<StockItem> stocks = new ArrayList<>();
        BufferedReader br = null;

        try {
            File location = new File("C:\\Users\\Jihye\\Desktop\\recentNewsByStock\\src\\main\\resources\\static\\assets\\stocklist.csv");
            br = new BufferedReader(new FileReader(location));
            Charset.forName("UTF-8");
            String line = "";
            while ((line = br.readLine()) != null) {
                String array[] = line.split(",");
                //logger.info(line);
                if(array[1].equals("종목코드")) continue;
                StockItem stockItem = new StockItem(array[0], Integer.parseInt(array[1]));
                stocks.add(stockItem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stocks;
    }
}
