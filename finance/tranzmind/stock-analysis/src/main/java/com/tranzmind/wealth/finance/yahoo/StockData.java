package com.tranzmind.wealth.finance.yahoo;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockData {
	
	private String ticker;
	
	public static void main(String[] cmd) {
		
		StockData ticker = new StockData("AAPL");		
		ticker.getStockData();		
	}
	
	private StockData(String ticker) {		
		this.ticker = ticker;
	}
	
	private void getStockData() {
		
		Stock stock = null;
		
		try {
			stock = YahooFinance.get(this.ticker);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(null != stock) {
			//BigDecimal price = stock.getQuote().getPrice();
			//BigDecimal change = stock.getQuote().getChangeInPercent();
			//BigDecimal peg = stock.getStats().getPeg();
			//BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
	
			stock.print();
		}
	}

}
