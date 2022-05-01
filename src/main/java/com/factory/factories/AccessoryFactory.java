package com.factory.factories;

import com.common.uniq_id.VINgiver;
import com.factory.product.Accessory;
import com.factory.product.Body;
import com.factory.product.Motor;

public class AccessoryFactory implements IFactory<Accessory>
{
    private VINgiver vinGiver = new VINgiver();

    @Override
    public synchronized Accessory create() 
    {
        return new Accessory(vinGiver.getVIN());
    }

    @Override
    public Accessory create(Accessory accessory, Body body, Motor motor) { return null;}
}
