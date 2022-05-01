package com.factory.dealer;

import com.common.ProductsCounter;
import com.factory.product.Car;
import com.factory.storage.Storage;
import com.logger.ManufactureLogger;
import com.threadpool.Task;

public class Dealer implements Task 
{
    private Storage<Car> carStorage;
    private ProductsCounter<Car> carsSolded;
    private int ID;
    private boolean logSale;
    private int waitTime;
    private ManufactureLogger logger;

    public Dealer(int ID, Storage<Car> carStorage, ProductsCounter<Car> carsSolded, boolean logSale, int waitTime, ManufactureLogger logger)
    {
        super();
        this.ID = ID;
        this.carStorage = carStorage;
        this.carsSolded = carsSolded;
        this.logSale = logSale;
        this.waitTime = waitTime;
        this.logger = logger;
    }

    @Override
    public void performWork() throws InterruptedException 
    {
        while(true)
        {
            Car car = carStorage.getProduct();
            carsSolded.increment();
            String saleMessage = "Dealer <" + ID + ">: Auto: <" + car.getVIN() + ">(Body: <" + car.getBody().getVIN() + ">, Motor: <" + car.getMotor().getVIN() + ">, Accessory: <" + car.getAccessory().getVIN() + ">)";
            if (logSale)
            {
                logger.getInfoMessage(saleMessage);
            }
            //System.out.println(saleMessage);
            Thread.sleep(waitTime);
        }
        
    }

    public void setWaitTime(int waitTime)
    {
        this.waitTime = waitTime;
    }
}
