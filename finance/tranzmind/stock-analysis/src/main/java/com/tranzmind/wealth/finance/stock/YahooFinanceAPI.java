package com.tranzmind.wealth.finance.stock;

import java.io.*;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tranzmind.wealth.finance.stock.entity.QuoteSummary;

import lombok.Lombok;

import com.google.gson.Gson;

public class YahooFinanceAPI {

	public static void main(String[] cmd) throws FileNotFoundException {

		/*
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(
				"https://yahoo-finance-free.p.rapidapi.com/v11/finance/quoteSummary/AAPL?lang=en%20%257C%20fr%20%257C%20de%20%257C%20it%20%257C%20es%20%257C%20zh&region=US&modules=defaultKeyStatistics")
				.get().addHeader("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
				.addHeader("x-rapidapi-key", "13cb6f899bmshcd971f12386146bp1d9b2cjsn4667a881586a").build();

		try {
			Response response = client.newCall(request).execute();

			//printJSON(response.body().toString());
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		printJSON(new FileReader("jsonData.json"));
		
	}
	
	private static void printJSON(FileReader jsonDataReader) {
		
	Gson gson = new Gson();	
	QuoteSummary quoteSummary = gson.fromJson(jsonDataReader, QuoteSummary.class);
	

	System.out.println(quoteSummary.getQuoteSummary().getResult().get(0).getDefaultKeyStatistics().getBeta().getRaw());
	
	
		
	}

}