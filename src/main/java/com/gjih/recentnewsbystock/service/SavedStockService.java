package com.gjih.recentnewsbystock.service;

import com.gjih.recentnewsbystock.entity.SavedStock;
import com.gjih.recentnewsbystock.repository.SavedStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SavedStockService {

    private final SavedStockRepository savedStockRepository;

    /**
     * 관심종목 등록
     */
    @Transactional
    public Long join(SavedStock stock) {
        savedStockRepository.save(stock);
        return stock.getId();
    }

    /**
     * 관심종목 불러오기
     */
    public List<SavedStock> findSavedStock(Long memberId) {
        return savedStockRepository.findAllByMemberId(memberId);
    }

    public List<SavedStock> findAll() {
        return savedStockRepository.findAll();
    }

    /**
     * 관심종목 삭제
     */
    @Transactional
    public void deleteSavedStock(Long memberId, String stockName) {
        List<SavedStock> list = savedStockRepository.findByMemberIdStockName(memberId, stockName);
        if (list.size() != 1) {
            throw new IllegalStateException(stockName + " 종목이 해당 회원 정보로 여러번 저장되어있습니다.");
        }
        SavedStock savedStock = list.get(0);
        savedStockRepository.remove(savedStock);
    }

}
