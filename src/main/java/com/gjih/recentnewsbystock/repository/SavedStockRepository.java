package com.gjih.recentnewsbystock.repository;

import com.gjih.recentnewsbystock.entity.Member;
import com.gjih.recentnewsbystock.entity.SavedStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SavedStockRepository {

    private final EntityManager em;

    /**
     * 종목 추가
     */
    public void save(SavedStock stock) {
        em.persist(stock);
    }

    public SavedStock findOne(Long id) {
        return em.find(SavedStock.class, id);
    }

    public List<SavedStock> findAllByMemberId(Long memberId) {
        return em.createQuery("select s from SavedStock s where s.member = :memberId", SavedStock.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    /**
     * 종목 삭제
     */
    public void remove(SavedStock stock) {
        em.detach(stock);
    }
}
