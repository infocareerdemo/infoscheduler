package com.infoscheduler.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.infoscheduler.entity.StockCash;
import com.infoscheduler.entity.StockPrice;
import com.infoscheduler.repository.StockCashRepository;
import com.infoscheduler.repository.StockPriceRepository;

@Service
public class StockPriceDailyUpdateService {

	@Autowired(required = false)
	private StockPriceRepository stockPriceRepository;

	@Autowired
	StockCashRepository stockCashRepository;

	public List<StockPrice> stockPriceEQDailyUpdate(String series, String timestamp) {
		System.out.print("\n - stockPriceEQDailyUpdate");	

		List<StockPrice> stockPrices = new ArrayList<>();

		List<StockCash> dsStockCash = stockCashRepository.findBySeriesAndTimestamp(series, timestamp);
		List<StockPrice> dsStockPrice = stockPriceRepository.findBySpinstrument(series);

		if (!dsStockCash.isEmpty()) {
			System.out.print("\n - stockPriceEQDailyUpdate - inside the if"+dsStockCash.toString());
			
			for (StockCash sc : dsStockCash) {
				
				Optional<StockPrice> spList = dsStockPrice.stream().filter(sp -> sp.getSpsymbol().equalsIgnoreCase(sc.getSymbol())).findFirst();
				
				if (spList.isPresent()) {
					System.out.print("\n - stockPriceEQDailyUpdate -"+spList.toString());

					spList.get().setTdopen(sc.getOpen());
					spList.get().setTdclose(sc.getClose());
					spList.get().setTdlow(sc.getLow());
					spList.get().setTdhigh(sc.getHigh());
					spList.get().setTdtimestamp(sc.getTimestamp());
					spList.get().setSlastupdatedate(new Date());
					
					stockPriceRepository.save(spList.get());
					System.out.print("\n"+spList.toString());

					stockPrices.add(spList.get());

					
				}
			}
		}

		return stockPrices;
	}

}