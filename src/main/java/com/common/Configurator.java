package com.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurator 
{
    private int storageBodySize;
    private int storageAccessorySize;
    private int storageMotorSize;
    private int storageCarSize;
    private int accessorySuppliers;
    private int bodySuppliers;
    private int motorSuppliers;
    private int workers;
    private int dealers;
    private boolean logSale;

    public Configurator()
    {
        Properties properties = new Properties();
        try
        {
            InputStream in = Configurator.class.getClassLoader().getResourceAsStream("configuration.properties");
            properties.load(in);
        }
        catch (NullPointerException | IOException e)
        {
            e.printStackTrace();
        }

        storageBodySize = Integer.parseInt(properties.getProperty("StorageBodySize"));
        storageAccessorySize = Integer.parseInt(properties.getProperty("StorageAccessorySize"));
        storageMotorSize = Integer.parseInt(properties.getProperty("StorageMotorSize"));
        storageCarSize = Integer.parseInt(properties.getProperty("StorageCarSize"));
        accessorySuppliers = Integer.parseInt(properties.getProperty("AccessorySuppliers"));
        bodySuppliers = Integer.parseInt(properties.getProperty("BodySuppliers"));
        motorSuppliers = Integer.parseInt(properties.getProperty("MotorSuppliers"));
        workers = Integer.parseInt(properties.getProperty("Workers"));
        dealers = Integer.parseInt(properties.getProperty("Dealers"));
        logSale = Boolean.parseBoolean(properties.getProperty("LogSale"));
    }

    public int getStorageBodySize()
    {
        return storageBodySize;
    }

    public int getStorageAccessorySize()
    {
        return storageAccessorySize;
    }

    public int getStorageMotorSize()
    {
        return storageMotorSize;
    }

    public int getStorageCarSize()
    {
        return storageCarSize;
    }

    public int getAccessorySuppliers()
    {
        return accessorySuppliers;
    }

    public int getBodySuppliers()
    {
        return bodySuppliers;
    }

    public int getMotorSuppliers()
    {
        return motorSuppliers;
    }

    public int getWorkers()
    {
        return workers;
    }

    public int getDealers()
    {
        return dealers;
    }

    public boolean isLogSale()
    {
        return logSale;
    }
}
