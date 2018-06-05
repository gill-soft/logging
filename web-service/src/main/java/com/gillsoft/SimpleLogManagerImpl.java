package com.gillsoft;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.gillsoft.model.ILogManager;
import com.gillsoft.model.Log;

@Component("ILogManager")
public class SimpleLogManagerImpl implements ILogManager {
	
	private static final Logger LOGGER = LogManager.getLogger();

	public boolean save(List<Log> logs) {
		for (Log log : logs) {
			if (log.getType() != null) {
				switch (log.getType()) {
				case DEBUG:
					LOGGER.debug(log.getMessage());
					break;
	
				case INFO:
					LOGGER.info(log.getMessage());
					break;
	
				case WARN:
					LOGGER.warn(log.getMessage());
					break;
	
				case ERROR:
					LOGGER.error(log.getMessage());
					break;
	
				default:
					LOGGER.info(log.getMessage());
					break;
				}
			} else {
				LOGGER.info(log.getMessage());
			}
		}
		return true;
	}

}
