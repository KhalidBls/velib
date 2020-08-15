package com.veloslyon.velib.repository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RequestAPI {

    private String url= "https://api.jcdecaux.com/vls/v1/stations?";
    private String contract = "contract=lyon";
    private String apiKey = "&apiKey=bde09ea11fef33327232c69bebab6569d6b275fd";


	public JSONArray recupererInfos() throws Exception {
		URL apiUrl = new URL(url+contract+apiKey);
		String inline = "";
		HttpURLConnection conn = (HttpURLConnection)apiUrl.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		if(responsecode != 200)
			throw new RuntimeException("HttpResponseCode: " +responsecode);
		else{
			Scanner sc = new Scanner(apiUrl.openStream());
			while(sc.hasNext())
			{
				inline+=sc.nextLine();
			}
			sc.close();
		}

		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray) parser.parse(inline);
		return arr;
	}



}
