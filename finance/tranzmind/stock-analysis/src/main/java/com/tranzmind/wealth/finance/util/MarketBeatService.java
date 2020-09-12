package com.tranzmind.wealth.finance.util;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.tranzmind.wealth.finance.stock.IStock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MarketBeatService {

	public static void main(String[] cmd) throws IOException {

		for (String ticker : IStock.tickers) {
			log.info("Analyst Rating for {}", ticker);
			Document tickerDoc = Jsoup.connect("https://www.marketbeat.com/stocks/NASDAQ/"+ticker+"/").get();

			// Document tickerDoc = Jsoup.parse(new File("TSLA.html"), "UTF-8");

			Elements analystRating = tickerDoc.getElementsByClass("rankAnalyst");

			for (String text : analystRating.text().split("(?<=[a-z])\\.\\s+")) {
				log.info(text+"\n");
			}

		}

	}
}