package com.gjih.recentnewsbystock.repository;

import com.gjih.recentnewsbystock.entity.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StockRepository {

    private final EntityManager em;

    /**
     * 종목 추가
     */
    public void save(Stock stock) {
        em.persist(stock);
    }

    public Stock findOne(Long id) {
        return em.find(Stock.class, id);
    }

    public List<Stock> findAllByMemberId(Long memberId) {
        return em.createQuery("select s from Stock s where s.member = :memberId", Stock.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    public List<Stock> findByMemberIdStockName(Long memberId, String stockName) {
        return em.createQuery("select s from Stock s where s.member = :memberId and s.stockName = :stockName", Stock.class)
                .setParameter("memberId", memberId)
                .setParameter("stockName", stockName)
                .getResultList();
    }

    public List<Stock> findAll() {
        return em.createQuery("select s from Stock s", Stock.class)
                .getResultList();
    }

    /**
     * 종목 삭제
     */
    public void remove(Stock stock) {
        em.detach(stock);
    }
}
