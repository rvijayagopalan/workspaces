package roosevelt.libraries.auth.util;

import org.apache.log4j.Logger;

public class AuthXUtilLog4J{

	private static Logger logger = Logger.getLogger(AuthXUtilLog4J.class);

	public static void log(String log) {

		logger.info("Logging from AuthX Util Log4J Project!!  " + " -> " + log);
	}
}