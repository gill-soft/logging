package com.gillsoft.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.gillsoft.model.Log;

public class Client {
	
	public static void main(String[] args) {
//		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		RestTemplate template = new RestTemplate();
		List<Log> logs = new ArrayList<>();
		logs.add(new Log());
		logs.add(new Log());
		ResponseEntity<String> resp = template.postForEntity("http://localhost:8080/web-service/api/v1/log", logs, String.class, null, null);
		System.out.println();
	}
	
}
