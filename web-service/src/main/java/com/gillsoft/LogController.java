package com.gillsoft;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gillsoft.model.ILogManager;
import com.gillsoft.model.Log;

@RestController
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private ILogManager manager;
	
	@PostMapping
	public void save(@RequestBody List<Log> logs) {
		for (Log log : logs) {
			System.out.println(log);
		}
		manager.save(logs);
	}

}
