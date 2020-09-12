import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tranzmind.wealth.finance.stock.AlphaVantageAPI;

public class YahooFinanceTrending {

	public static void main(String[] cmd) throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url("https://yahoo-finance-free.p.rapidapi.com/v1/finance/trending/US")
				.get().addHeader("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
				.addHeader("x-rapidapi-key", "13cb6f899bmshcd971f12386146bp1d9b2cjsn4667a881586a").build();

		Response response = client.newCall(request).execute();

		String jsonString = response.body().string();

		Gson gson = new Gson();

		Map<String, Map> map = gson.fromJson(jsonString, Map.class);

		Map<String, List> finance = map.get("finance");
		List<Map> result = finance.get("result");

		List<Map<String, String>> quotes;

		for (Map resultItem : result) {
			quotes = (List<Map<String, String>>) resultItem.get("quotes");
			for (Map<String, String> quote : quotes) {
				System.out.println(quote.get("symbol"));
				//AlphaVantageAPI.getTimeSeries(quote.get("MIST"));
				//AlphaVantageAPI.getRSI(quote.get("symbol"));
				//AlphaVantageAPI.getTimeSeriesIntraDay("MIST");
				//break;
			}
		}
	}

}
