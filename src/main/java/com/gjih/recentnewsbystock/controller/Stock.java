package com.gjih.recentnewsbystock.controller;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    private String name;
    private String code;
    private boolean selected = false;

    public Stock(String name, String code) {
        this.name = name;
        this.code = code;
    }

}
