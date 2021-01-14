package com.ushwamala.thymeleaf.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.*;

@SpringBootApplication
public class SpringBootThymeleafDemoAppApplication {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) throws IOException {

        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        logger.addHandler(consoleHandler);

        try {

            FileHandler fileHandler = new FileHandler("myLogger.log");
            fileHandler.setLevel(Level.FINE);
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "File logger not working: ", e.getMessage());
        }

        logger.log(Level.SEVERE, "First log");


        SpringApplication.run(SpringBootThymeleafDemoAppApplication.class, args);
    }

}
