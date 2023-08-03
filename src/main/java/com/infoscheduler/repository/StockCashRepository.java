package com.infoscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infoscheduler.entity.StockCash;

public interface StockCashRepository extends JpaRepository<StockCash, Integer> {

	 List<StockCash> findBySeriesAndTimestamp(String series, String timestamp);

}
