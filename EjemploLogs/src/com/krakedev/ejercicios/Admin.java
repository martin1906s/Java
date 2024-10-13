package com.krakedev.ejercicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin {
	private static Logger logger=LogManager.getFormatterLogger(Admin.class);
	public void agregar() {
		logger.info("Mensaje de info");
		logger.warn("Mensaje de warn");
		logger.trace("Mensaje de trace");
		logger.error("Mensaje de error");
		logger.debug("Mensaje de debug");


	}
	
}
