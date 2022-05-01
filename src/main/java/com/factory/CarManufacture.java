package com.factory;

import com.common.Configurator;
import com.common.ProductsCounter;
import com.factory.dealer.Dealers;
import com.factory.factories.AccessoryFactory;
import com.factory.factories.BodyFactory;
import com.factory.factories.CarFactory;
import com.factory.factories.MotorFactory;
import com.factory.product.Accessory;
import com.factory.product.Body;
import com.factory.product.Car;
import com.factory.product.Motor;
import com.factory.storage.Storage;
import com.factory.supplier.Suppliers;
import com.factory.worker.Workers;

public class CarManufacture 
{
    private ProductsCounter<Accessory> accessoryCounter;
    private ProductsCounter<Body> bodyCounter;
    private ProductsCounter<Motor> motorCounter;
    private ProductsCounter<Car> soldedCars;
    private ProductsCounter<Car> assembledCars;

    private Storage<Accessory> accessoryStorage;
    private Storage<Body> bodyStorage;
    private Storage<Motor> motorStorage;
    private Storage<Car> carStorage;

    private Suppliers<Accessory> accessorySuppliers;
    private Suppliers<Body> bodySuppliers;
    private Suppliers<Motor> motorSuppliers;

    private Dealers dealers;
    private Workers workers;

    public CarManufacture(Configurator configurator)
    {
        accessoryStorage = new Storage<Accessory>(configurator.getStorageAccessorySize());
        bodyStorage = new Storage<>(configurator.getStorageBodySize());
        motorStorage = new Storage<>(configurator.getStorageMotorSize());
        carStorage = new Storage<>(configurator.getStorageCarSize());

        AccessoryFactory accessoryFactory = new AccessoryFactory();
        BodyFactory bodyFactory = new BodyFactory();
        MotorFactory motorFactory = new MotorFactory();
        CarFactory carFactory = new CarFactory();

        accessoryCounter = new ProductsCounter<>();
        bodyCounter = new ProductsCounter<>();
        motorCounter = new ProductsCounter<>();
        soldedCars = new ProductsCounter<>();
        assembledCars = new ProductsCounter<>();

        accessorySuppliers = new Suppliers<>(configurator.getAccessorySuppliers(), accessoryStorage, accessoryFactory, accessoryCounter);
        bodySuppliers = new Suppliers<>(configurator.getBodySuppliers(), bodyStorage, bodyFactory, bodyCounter);
        motorSuppliers = new Suppliers<>(configurator.getMotorSuppliers(), motorStorage, motorFactory, motorCounter);

        dealers = new Dealers(carStorage, soldedCars, configurator.getDealers(), configurator.isLogSale());
        workers = new Workers(accessoryStorage, bodyStorage, motorStorage, carStorage, carFactory, assembledCars, configurator.getWorkers());
    }

    public Suppliers<Accessory> getAccessorySuppliers()
    {
        return accessorySuppliers;
    }

    public Suppliers<Body> getBodySuppliers()
    {
        return bodySuppliers;
    }

    public Suppliers<Motor> getMotorSuppliers()
    {
        return motorSuppliers;
    }

    public Dealers getDealers()
    {
        return dealers;
    }

    public Workers getWorkers()
    {
        return workers;
    }

    public ProductsCounter<Accessory> getAccessoryCounter()
    {
        return accessoryCounter;
    }

    public ProductsCounter<Body> getBodyCounter()
    {
        return bodyCounter;
    }

    public ProductsCounter<Motor> getMotorCounter()
    {
        return motorCounter;
    }

    public ProductsCounter<Car> getSoldedCarsCounter()
    {
        return soldedCars;
    }

    public int getCurrentAccessoryStorageCount()
    {
        return accessoryStorage.getNumberOfProduct();
    }

    public int getCurrentMotorStorageCount()
    {
        return motorStorage.getNumberOfProduct();
    }

    public int getCurrentBodyStorageCount()
    {
        return bodyStorage.getNumberOfProduct();
    }

    public int getCurrentCarStorageCount()
    {
        return carStorage.getNumberOfProduct();
    }

    public Storage<Accessory> getAccessoryStorage()
    {
        return accessoryStorage;
    }

    public Storage<Body> getBodyStorage()
    {
        return bodyStorage;
    }

    public Storage<Motor> getMotorStorage()
    {
        return motorStorage;
    }

    public Storage<Car> getCarStorage()
    {
        return carStorage;
    }
}
