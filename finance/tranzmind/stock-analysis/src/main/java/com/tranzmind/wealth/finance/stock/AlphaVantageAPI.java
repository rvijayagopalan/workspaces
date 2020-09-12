package com.tranzmind.wealth.finance.stock;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class AlphaVantageAPI {
	
	@Autowired
	static RestTemplate restTemplate;

	public static void main(String[] args) throws IOException {

		getCMO("MIST");
		//getTimeSeriesIntraDay("AAPL");
	}
	

	public static void getCMO(String ticker) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("	https://www.alphavantage.co/query?function=CMO&interval=weekly&time_period=10&series_type=close&apikey=VX39C7NJDNVB23C4&symbol="+ticker)
				.get().build();
		
		Response response = client.newCall(request).execute();
		
		System.out.println(response.body().string());
	}

	
	public static void getRSI(String ticker) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://www.alphavantage.co/query?function=RSI&symbol="+ticker+"&interval=daily&time_period=10&series_type=open&apikey=VX39C7NJDNVB23C4")
				.get().build();
		
		Response response = client.newCall(request).execute();
		
		System.out.println(response.body().string());
	}
	
	public static void getTimeSeries(String ticker) throws IOException {		
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
						
			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder()
					.url("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&apikey=VX39C7NJDNVB23C4&interval=5min&symbol="+ticker)
					.get().build();
			
			Response response = client.newCall(request).execute();
			
			System.out.println(response.body().string());

	}
	
	public static void getTimeSeriesIntraDay(String ticker) throws IOException {		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
					
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&interval=5min&apikey=VX39C7NJDNVB23C4&symbol="+ticker)
				.get().build();
		
		Response response = client.newCall(request).execute();
		
		System.out.println(response.body().string());
	}

}
	




