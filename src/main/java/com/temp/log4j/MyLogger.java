package com.temp.log4j;


import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;

public class MyLogger {

	//mainLogger is a logger object that we got from LogManager. All loggers are 
        //using this method only. We can consider LogManager as a factory to create
        //Logger objects
	 Logger mainLogger = LogManager.getLogger(Logger.class.getName());
	
	 
	 
	public Logger getMainLogger1() {
		return mainLogger;
	}


	public void setMainLogger(Logger mainLogger) {
		this.mainLogger = mainLogger;
	}


	public MyLogger() {
		BasicConfigurator.configure();
		 
		 //Create a console appender and attach it to our mainLogger
		 ConsoleAppender appender = new ConsoleAppender();
		 appender.activateOptions();
		 PatternLayout layoutHelper = new PatternLayout();
		 FileAppender fileAppender = new FileAppender();
		 try {
			fileAppender.setFile("logfile_"+System.currentTimeMillis()+".txt", false, false, 0);
		} catch (IOException e) {

			e.printStackTrace();
		}
//	      fileAppender.setFile("logfile.txt");
	      fileAppender.setLayout(new SimpleLayout());
		 layoutHelper.setConversionPattern("%-5p [%t]: %m%n");
		 layoutHelper.activateOptions();
	
		 appender.setLayout(layoutHelper);
		 
		 mainLogger.addAppender(fileAppender);

		 fileAppender.activateOptions();
		 mainLogger.info("Logging events"); 

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicConfigurator.configure();
//		mainLogger.info("Initialising Logger for temperature testing Application");	

	}


	public Logger getMainLogger() {
		// TODO Auto-generated method stub
		return mainLogger;
	}
}
