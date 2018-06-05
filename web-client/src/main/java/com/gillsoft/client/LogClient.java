package com.gillsoft.client;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.gillsoft.model.Log;

public class LogClient {
	
	private static LogClient instance;
	
	private ExecutorService executor;
	private RestTemplate template;
	
	private LogClient() {
		executor = Executors.newFixedThreadPool(10);
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(1000);
		factory.setConnectionRequestTimeout(500);
		template = new RestTemplate(factory);
	}
	
	public static LogClient getInstance() {
		if (instance == null) {
			synchronized (LogClient.class) {
				if (instance == null) {
					instance = new LogClient();
				}
			}
		}
		return instance;
	}
	
	public void send(Log log) {
		send(new SendLogTask(template, Config.getUrl(), log));
	}
	
	public void send(List<Log> logs) {
		send(new SendLogTask(template, Config.getUrl(), logs));
	}
	
	public void send(SendLogTask task) {
		executor.execute(task);
	}
	
	public void release() {
		executor.shutdown();
	}
	
}
