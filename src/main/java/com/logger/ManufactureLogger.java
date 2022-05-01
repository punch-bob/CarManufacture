package com.logger;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.Main;

public class ManufactureLogger
{
    private final Logger log;

    public ManufactureLogger()
    {
        try 
        {
            LogManager.getLogManager().readConfiguration(Main.class.getClassLoader().getResourceAsStream("logging.properties"));
        } 
        catch (SecurityException | IOException e) 
        {
            e.printStackTrace();
        }
        
        this.log = Logger.getLogger(Logger.class.getName());
    }

    public void getInfoMessage(String message)
    {
        log.log(Level.INFO, "\nDeliver performed: " + message + "\n");
    }
}
