package com.factory.factories;

import com.common.uniq_id.VINgiver;
import com.factory.product.Accessory;
import com.factory.product.Body;
import com.factory.product.Car;
import com.factory.product.Motor;

public class CarFactory implements IFactory<Car>
{
    private VINgiver vinGiver = new VINgiver();

    @Override
    public Car create(Accessory accessory, Body body, Motor motor) 
    {
        return new Car(accessory, body, motor, vinGiver.getVIN());
    }

    @Override
    public Car create() { return null; }
}
