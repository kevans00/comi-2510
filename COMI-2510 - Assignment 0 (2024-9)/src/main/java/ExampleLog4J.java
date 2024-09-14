import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExampleLog4J {

	private static final Logger logger = LogManager.getLogger(ExampleLog4J.class.getName());
		
	public static void main(String[] args) {
		ExampleLog4J.logger.trace("Hello this is a TRACE message.");
		ExampleLog4J.logger.debug("Hello this is a DEBUG message.");
		ExampleLog4J.logger.info("Hello this is an INFO message.");
		ExampleLog4J.logger.warn("Hello this is an WARN message.");
		ExampleLog4J.logger.error("Hello this is an ERROR message.");
		ExampleLog4J.logger.fatal("Hello this is an FATAL message.");
	}
	
	 public ExampleLog4J()
	    {
		super();
	    }
}
