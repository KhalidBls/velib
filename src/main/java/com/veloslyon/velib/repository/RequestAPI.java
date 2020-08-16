package com.veloslyon.velib.repository;

import com.veloslyon.velib.models.Stations;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RequestAPI {

    private String url= "https://api.jcdecaux.com/vls/v1/stations?";
    private String contract = "contract=lyon";
    private String apiKey = "&apiKey=bde09ea11fef33327232c69bebab6569d6b275fd";
    private JSONArray jsonArray;
    List<Stations> stationsRepo = new ArrayList<>();

	public List<Stations> getStationsRepo() {
		return stationsRepo;
	}

	public RequestAPI() throws Exception {
    	jsonArray = recupererInfos();
		parseJSONtoStations();
	}

	public void parseJSONtoStations(){
		Iterator i = jsonArray.iterator();

		while (i.hasNext()) {

			JSONObject jobj = (JSONObject) i.next();

			double[] positions = new double[2];
			JSONObject json =  (JSONObject)jobj.get("position");

			positions[0] = (double) json.get("lat");
			positions[1] = (double) json.get("lng");

			stationsRepo.add(new Stations((long) jobj.get("number"),(String) jobj.get("contract_name"),
					(String)jobj.get("name"),(String)jobj.get("address")
            ,positions, (boolean)jobj.get("banking"), (boolean)jobj.get("bonus"), (long) jobj.get("bike_stands")
            , (long) jobj.get("available_bike_stands"),(long) jobj.get("available_bikes"), (String)jobj.get("status"), (long)jobj.get("last_update")));
		}
	}

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
