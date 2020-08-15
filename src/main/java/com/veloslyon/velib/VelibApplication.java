package com.veloslyon.velib;

import com.veloslyon.velib.repository.RequestAPI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VelibApplication {

	public static void main(String[] args) throws Exception {
		RequestAPI api = new RequestAPI();
		JSONArray objet = api.recupererInfos();

		System.out.println(objet.get(0));


		SpringApplication.run(VelibApplication.class, args);
	}

}
