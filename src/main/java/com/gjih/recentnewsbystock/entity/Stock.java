package com.gjih.recentnewsbystock.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Stock {

    @Id
    @GeneratedValue
    @Column(name = "save_stock_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "stock_id")
    private int code; // 종목코드

    @Column(name = "stork_name")
    private String name;

    // 연관관계 메서드
    /*public void setMember(Member member) {
        this.member = member;
        member.getStocks().add(this);
    }*/

    // 생성 메서드
    /*public static Stock addStock(Member member, Long code, String name) {
        Stock stock = new Stock();
        stock.setMember(member);
    }*/

}
