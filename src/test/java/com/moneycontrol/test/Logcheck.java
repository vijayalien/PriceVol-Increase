package com.moneycontrol.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Logcheck {
	
	public static Logger log = LogManager.getLogger(Logcheck.class.getName());
	
	
	@Test
	public static void logtest() {
		log.info("info messge");
		log.debug("Debug message");
		log.error("Error message");
		log.trace("Trace message");
		
	}

}
