package com.gillsoft;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gillsoft.model.ILogManager;
import com.gillsoft.model.Log;

@Component("ILogManager")
public class SimpleLogManagerImpl implements ILogManager {

	public boolean save(List<Log> logs) {
		// TODO Auto-generated method stub
		return true;
	}

}
