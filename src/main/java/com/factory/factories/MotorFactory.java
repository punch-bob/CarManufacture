package com.factory.factories;

import com.common.uniq_id.VINgiver;
import com.factory.product.Accessory;
import com.factory.product.Body;
import com.factory.product.Motor;

public class MotorFactory implements IFactory<Motor>
{
    private VINgiver vinGiver = new VINgiver();

    @Override
    public Motor create() 
    {
        return new Motor(vinGiver.getVIN());
    }

    @Override
    public Motor create(Accessory accessory, Body body, Motor motor) { return null; }
}
