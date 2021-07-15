package com.gjih.recentnewsbystock.service;

import com.gjih.recentnewsbystock.controller.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    public List<Stock> getStockList() {
        List<Stock> stocks = new ArrayList<>();
        BufferedReader br = null;

        try {
            File location = new File("C:\\Users\\Jihye\\Desktop\\recentNewsByStock\\src\\main\\resources\\static\\assets\\stocklist.csv");
            br = new BufferedReader(new FileReader(location));
            String line = "";
            while ((line = br.readLine()) != null) {
                String array[] = line.split(",");

                Stock stock = new Stock(array[0], array[1]);
                stocks.add(stock);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stocks;
    }
}
