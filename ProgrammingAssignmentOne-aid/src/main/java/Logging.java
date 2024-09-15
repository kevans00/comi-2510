import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
	private static final Logger logger = LogManager.getLogger(Logging.class.getName());
	
	public static void main(String[] args) {
		Logging.logger.trace("Hello this is a TRACE message.");
		Logging.logger.debug("Hello this is a DEBUG message.");
		Logging.logger.info("Hello this is an INFO message.");
		Logging.logger.warn("Hello this is an WARN message.");
		Logging.logger.error("Hello this is an ERROR message.");
		Logging.logger.fatal("Hello this is an FATAL message.");
	}
	
	 public Logging()
	    {
		super();
	    }
}
