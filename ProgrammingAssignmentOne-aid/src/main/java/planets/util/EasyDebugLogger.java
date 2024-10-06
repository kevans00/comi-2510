package planets.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import test.MainTest;

public class EasyDebugLogger {
	
	private static final Logger logger = LogManager.getLogger(EasyDebugLogger.class.getName());
	
	public EasyDebugLogger() {}
	
	public void formatLogger(String message, Object... args) {
		// Helper method that combines formating and logging in one
		String logMessage = String.format(message, args);
		EasyDebugLogger.logger.debug(logMessage);
	}
	

}
