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

    @Column(name = "stork_name")
    private String stockName;

    // 연관관계 메서드
    /*public void setMember(Member member) {
        this.member = member;
        member.getSavedStocks().add(this);
    }*/

    // 생성 메서드
    /*public static SavedStock addSavedStock(Member member, Long code, String name) {
        SavedStock savedStock = new SavedStock();
        savedStock.setMember(member);
    }*/

}
