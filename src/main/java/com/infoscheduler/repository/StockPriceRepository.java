package com.infoscheduler.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infoscheduler.entity.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Integer>, CrudRepository<StockPrice, Integer> {


	List<StockPrice> findBySpinstrument(String spinstrument);

}
