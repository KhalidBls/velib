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
		SpringApplication.run(VelibApplication.class, args);
	}

}
