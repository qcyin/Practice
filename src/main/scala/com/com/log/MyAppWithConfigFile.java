package com.com.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class MyAppWithConfigFile {

	//https://liuzidong.iteye.com/blog/776061

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(MyAppWithConfigFile.class);
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

		try {
			JoranConfigurator configurator = new JoranConfigurator();
			lc.reset();
			configurator.setContext(lc);
			// configurator.doConfigure("E:/testworkspace/SLF4J/src/chapters/architecture/sample-config-2.xml");
			configurator.doConfigure(MyAppWithConfigFile.class
					.getResourceAsStream("logback.xml"));
		} catch (JoranException je) {
			StatusPrinter.print(lc.getStatusManager());
		}
		logger.info("Entering application.");
		Bar bar = new Bar();
		bar.doIt();
		logger.info("Exiting application.");
		logger.warn("WARN...");
		logger.error("ERROR...");
	}
}
class Bar {

	private Logger logger = LoggerFactory.getLogger(Bar.class);

	void doIt() {
		logger.debug("doing my job");
	}
}