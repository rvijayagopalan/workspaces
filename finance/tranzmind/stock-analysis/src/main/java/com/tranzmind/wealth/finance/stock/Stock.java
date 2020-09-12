package com.tranzmind.wealth.finance.stock;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Stock {
	
	public List getStocks() {		
		List<String> stocks = new ArrayList<>();		
		return stocks;		
	}
	
	private void getTickerList(String filename) {
		
		Gson gson = new Gson(); 
		
		try {
			
			FileReader reader = new FileReader(filename);
			
			Ticker ticker = gson.fromJson(reader, Ticker.class);
			
			System.out.println(ticker.getTickers());
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] cmd) {		
		Stock stock = new Stock();
		stock.getTickerList("tickers.json");
	}
}