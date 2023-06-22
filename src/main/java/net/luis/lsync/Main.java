package net.luis.lsync;

import javafx.application.Application;
import net.luis.utils.annotation.AutoInitialize;
import net.luis.utils.util.unsafe.classpath.ClassPathUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Luis-St
 *
 */

public class Main {
	
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		Application.launch(LSync.class, args);
	}
	
	static {
		ClassPathUtils.getAnnotatedClasses("net.luis.lsync", AutoInitialize.class).forEach(clazz -> LOGGER.debug("Auto initialized class {}", clazz.getSimpleName()));
	}
}
