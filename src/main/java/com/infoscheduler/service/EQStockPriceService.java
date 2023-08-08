package com.infoscheduler.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoscheduler.entity.StockCash;
import com.infoscheduler.entity.StockPrice;
import com.infoscheduler.repository.StockCashRepository;
import com.infoscheduler.repository.StockPriceRepository;

@Service
public class EQStockPriceService {

	@Autowired
	private StockPriceRepository stockPriceRepository;

	@Autowired
	StockCashRepository stockCashRepository;

	
	public String pDayEQStockPriceData(String series, String timestamp) {
		
		List<StockPrice> stockPrices = new ArrayList<>();

        List<StockCash> stockCashs = stockCashRepository.findBySeriesAndTimestamp(series, timestamp);
        List<StockPrice> stPrices = stockPriceRepository.findBySpinstrument(series);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String date1 = formatter.format(date);


        if (!stockCashs.isEmpty()) {

            for (StockCash stc : stockCashs) {
                Optional<StockPrice> stList = stPrices.stream().filter(sp -> sp.getSpsymbol().equalsIgnoreCase(stc.getSymbol())).findFirst();
              
                if (stList.isPresent()) {

                    stList.get().setTdopen(stc.getOpen());
                    stList.get().setTdclose(stc.getClose());
                    stList.get().setTdlow(stc.getLow());
                    stList.get().setTdhigh(stc.getHigh());
                    stList.get().setPdtimestamp(stc.getTimestamp());
                    stList.get().setSlastupdatedate(new Date());
                    
                    stockPriceRepository.save(stList.get());

                    stockPrices.add(stList.get());
                }
            }
        }

         return "StockPrice for EQ Daily Update completed";
	}
	
	
	
	
	public String pWeekEQStockPriceData(String series, String fromtimestamp, String totimestamp) {
		
		List<StockPrice> stockPrices = new ArrayList<>();

        List<StockCash> stockCashs = stockCashRepository.findBySeriesAndTimestampBetween(series, fromtimestamp, totimestamp);
        List<StockPrice> stPrices = stockPriceRepository.findBySpinstrument(series);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String date1 = formatter.format(date);


        if (!stockCashs.isEmpty()) {

            for (StockCash stc : stockCashs) {
                Optional<StockPrice> stList = stPrices.stream().filter(sp -> sp.getSpsymbol().equalsIgnoreCase(stc.getSymbol())).findFirst();
              
                if (stList.isPresent()) {

                    stList.get().setTdopen(stc.getOpen());
                    stList.get().setTdclose(stc.getClose());
                    stList.get().setTdlow(stc.getLow());
                    stList.get().setTdhigh(stc.getHigh());
                    stList.get().setPdtimestamp(stc.getTimestamp());
                    stList.get().setSlastupdatedate(new Date());
                    
                    stockPriceRepository.save(stList.get());

                    stockPrices.add(stList.get());
                }
            }
        }

         return "StockPrice for EQ Daily Update completed";
	}
	
	
	
}