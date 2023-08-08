package com.infoscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoscheduler.entity.StockCash;

public interface StockCashRepository extends JpaRepository<StockCash, Integer> {

	 List<StockCash> findBySeriesAndTimestamp(String series, String timestamp);

	 List<StockCash> findBySeriesAndTimestampBetween(String series, String timesstamp, String timestamp);

}
