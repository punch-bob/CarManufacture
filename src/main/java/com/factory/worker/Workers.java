package com.factory.worker;

import java.util.ArrayList;

import com.common.ProductsCounter;
import com.factory.factories.CarFactory;
import com.factory.product.Accessory;
import com.factory.product.Body;
import com.factory.product.Car;
import com.factory.product.Motor;
import com.factory.storage.Storage;

public class Workers 
{
    private ArrayList<Worker> workersList = new ArrayList<>();
    
    public Workers(Storage<Accessory> accessoryStorage, Storage<Body> bodyStorage, Storage<Motor> motorStorage, 
                   Storage<Car> carStorage, CarFactory carFactory, ProductsCounter<Car> assembledCars, int workers)
    {
        for(int i = 0; i < workers; ++i)
        {
            workersList.add(new Worker(accessoryStorage, bodyStorage, motorStorage, carStorage, carFactory, assembledCars));
        }
    }

    public ArrayList<Worker> getWorkersList()
    {
        return workersList;
    }
}
