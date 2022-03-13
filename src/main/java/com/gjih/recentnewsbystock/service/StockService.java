package com.gjih.recentnewsbystock.service;

import com.gjih.recentnewsbystock.entity.Stock;
import com.gjih.recentnewsbystock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    /**
     * 관심종목 등록
     */
    @Transactional
    public Long join(Stock stock) {
        stockRepository.save(stock);
        return stock.getId();
    }

    /**
     * 관심종목 불러오기
     */
    public List<Stock> findStock(Long memberId) {
        return stockRepository.findAllByMemberId(memberId);
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    /**
     * 관심종목 삭제
     */
    @Transactional
    public void deleteStock(Long memberId, String stockName) {
        List<Stock> list = stockRepository.findByMemberIdStockName(memberId, stockName);
        if (list.size() != 1) {
            throw new IllegalStateException(stockName + " 종목이 해당 회원 정보로 여러번 저장되어있습니다.");
        }
        Stock stock = list.get(0);
        stockRepository.remove(stock);
    }

}
