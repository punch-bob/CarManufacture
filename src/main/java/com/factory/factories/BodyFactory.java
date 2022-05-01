package com.factory.factories;

import com.common.uniq_id.VINgiver;
import com.factory.product.Accessory;
import com.factory.product.Body;
import com.factory.product.Motor;

public class BodyFactory implements IFactory<Body>
{
    private VINgiver vinGiver = new VINgiver();

    @Override
    public synchronized Body create() 
    {
        return new Body(vinGiver.getVIN());
    }

    @Override
    public Body create(Accessory accessory, Body body, Motor motor) { return null;}
}
