package com.factory.worker;

import com.common.ProductsCounter;
import com.factory.factories.CarFactory;
import com.factory.product.Accessory;
import com.factory.product.Body;
import com.factory.product.Car;
import com.factory.product.Motor;
import com.factory.storage.Storage;
import com.threadpool.Task;

public class Worker implements Task
{
    private Storage<Accessory> accessoryStorage;
    private Storage<Body> bodyStorage;
    private Storage<Motor> motorStorage;
    private Storage<Car> carStorage;
    private CarFactory carFactory;
    private ProductsCounter<Car> assembledCars;

    public Worker(Storage<Accessory> accessoryStorage, Storage<Body> bodyStorage, Storage<Motor> motorStorage, 
                  Storage<Car> carStorage, CarFactory carFactory, ProductsCounter<Car> assembledCars)
    {
        super();
        this.accessoryStorage = accessoryStorage;
        this.bodyStorage = bodyStorage;
        this.motorStorage = motorStorage;
        this.carStorage = carStorage;
        this.carFactory = carFactory;
        this.assembledCars = assembledCars;
    }

    @Override
    public void performWork() throws InterruptedException 
    {
        while(true)
        {
            Accessory accessory = accessoryStorage.getProduct();
            Body body = bodyStorage.getProduct();
            Motor motor = motorStorage.getProduct();
            Car car = carFactory.create(accessory, body, motor);
            assembledCars.increment();
            carStorage.addProduct(car);
        }   
    }
}
