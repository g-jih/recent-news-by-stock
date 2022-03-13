package com.gjih.recentnewsbystock.controller;

import com.gjih.recentnewsbystock.entity.Stock;
import com.gjih.recentnewsbystock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping(value = "/stocks/new")
    public String create(StockItem stockItem) {

        Stock stock = new Stock();
        stock.setName(stockItem.name);
        stock.setCode(stockItem.code);

        stockService.join(stock);
        return "redirect:/";
    }

}
