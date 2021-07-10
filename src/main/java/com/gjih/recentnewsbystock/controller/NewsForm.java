package com.gjih.recentnewsbystock.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewsForm {

    private String title;
    private String originallink;
    private String link;
    private String description;
    private Date pubDate;
}
