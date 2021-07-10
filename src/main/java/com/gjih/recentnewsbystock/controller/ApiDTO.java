package com.gjih.recentnewsbystock.controller;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ApiDTO {
    private String lastBuildDate;
    private Long total;
    private int start;
    private int display;
    private List<NewsForm> items;
}
