package com.veloslyon.velib;

import com.veloslyon.velib.repository.RequestAPI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;

@SpringBootApplication
public class VelibApplication {

	public static void main(String[] args) throws Exception {
		RequestAPI api = new RequestAPI();
		JSONArray objet = api.recupererInfos();

		System.out.println(objet.get(0));

		Iterator i = objet.iterator();

		while (i.hasNext()) {
			JSONObject slide = (JSONObject) i.next();
			String title = (String)slide.get("contract_name");
			System.out.println(title);
		}

		SpringApplication.run(VelibApplication.class, args);
	}

}
