package com.gillsoft.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.gillsoft.model.Log;

public class SendLogTask implements Runnable {
	
	private RestTemplate template;
	private String url;
	private List<Log> logs;
	private ResponseEntity<String> response;
	
	public SendLogTask(RestTemplate template, String url, Log log) {
		this.template = template;
		this.url = url;
		if (log != null) {
			logs = new ArrayList<>(1);
			logs.add(log);
		}
	}
	
	public SendLogTask(RestTemplate template, String url, List<Log> logs) {
		this.template = template;
		this.url = url;
		this.logs = logs;
	}

	@Override
	public void run() {
		if (logs != null
				&& !logs.isEmpty()) {
			response = template.postForEntity(url, logs, String.class, null, null);
		}
	}

	public ResponseEntity<String> getResponse() {
		return response;
	}

}
