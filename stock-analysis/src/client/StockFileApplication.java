package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {

	public static void main(String args[]) throws IOException {
		StockFileReader fr = new StockFileReader("AAPL.csv");

		System.out.println("Apple stock data for last one year");

		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println("Size of data:" + dataResult.size());
	}

	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		
		for (String line : lines) {
			String[] values = line.split(",");
			HashMap<String, Double> hm = new HashMap<>();
			int count = 0;
			for (String a : values) {
				double newval = Double.parseDouble(a);
				hm.put(headers.get(count), newval);
				count++;
			}
			dataResult.add(hm);
		}
		return dataResult;
	}
}
	

