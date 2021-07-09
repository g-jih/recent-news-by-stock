package com.gjih.recentnewsbystock.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SavedStock {

    @Id
    @GeneratedValue
    @Column(name = "save_stock_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "stock_id")
    private Long stockCode; // 종목코드

}
