package com.gillsoft.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.gillsoft.model.Log;

public class SendLogTask implements Callable<Integer> {
	
	private RestTemplate template;
	private String url;
	private List<Log> logs;
	
	private SendLogTask(RestTemplate template, String url, Log log) {
		this.template = template;
		this.url = url;
		if (log != null) {
			logs = new ArrayList<>(1);
			logs.add(log);
		}
	}
	
	private SendLogTask(RestTemplate template, String url, List<Log> logs) {
		this.template = template;
		this.url = url;
		this.logs = logs;
	}

	@Override
	public Integer call() throws Exception {
		if (logs == null
				|| logs.isEmpty()) {
			return HttpStatus.BAD_REQUEST.value();
		}
		ResponseEntity<String> resp = template.postForEntity(url, logs, String.class, null, null);
		return resp.getStatusCodeValue();
	}

}
