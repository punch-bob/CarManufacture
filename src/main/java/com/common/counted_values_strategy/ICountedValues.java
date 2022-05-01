package com.common.counted_values_strategy;

import com.common.publisher.ISubscriber;
import com.factory.CarManufacture;

public interface ICountedValues 
{
    public int getCount(CarManufacture manufacture);   
    public void addSubscriber(CarManufacture manufacture, ISubscriber subscriber);
}
