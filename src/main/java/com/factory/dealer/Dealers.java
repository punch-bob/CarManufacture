package com.factory.dealer;

import java.util.ArrayList;

import com.common.ProductsCounter;
import com.factory.product.Car;
import com.factory.storage.Storage;
import com.logger.ManufactureLogger;

public class Dealers 
{
    private ArrayList<Dealer> dealersList = new ArrayList<>();
    private ManufactureLogger logger = new ManufactureLogger();

    public Dealers(Storage<Car> carStorage,  ProductsCounter<Car> carsSolded, int dealers, boolean logSale)
    {
        for(int i = 1; i <= dealers; ++i)
        {
            dealersList.add(new Dealer(i, carStorage, carsSolded, logSale, 1000, logger));
        }
    }

    public ArrayList<Dealer> getDealersList()
    {
        return dealersList;
    }

    public void setWaitTime(int waitTime)
    {
        for(Dealer dealer : dealersList)
        {
            dealer.setWaitTime(waitTime);
        }
    }
}
