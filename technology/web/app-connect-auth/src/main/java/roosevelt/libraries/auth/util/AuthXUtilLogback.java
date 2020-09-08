package roosevelt.libraries.auth.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import ch.qos.logback.classic.Level;

public class AuthXUtilLogback {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthXUtilLogback.class);
	
	//private static ch.qos.logback.classic.Logger logbackLogger = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(AuthXUtilLogback.class);
	
	public static void main(String[] cmd) {
		
		//logbackLogger.setLevel(Level.INFO);
		
		log(logger, "Logging from AuthXUtilLogback");		
		//log(logbackLogger, "Logging from AuthXUtilLogback");
	}

	public static void log(Logger LOG, String message) {

		LOG.info("Logging from AuthX Util Logback !!  " + " -> " + message);

		LOG.trace("log a trace message {}", message);
		LOG.debug("log a debug message {}", message);
		LOG.info("log a info message {}", message);
		LOG.warn("log a warn message {}", message);
		LOG.error("log an error message {}", message);

	}
}