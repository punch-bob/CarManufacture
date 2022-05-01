package com.common.task_strategy;

import com.factory.CarManufacture;

public interface ITaskStrategy 
{
    public void setSpeed(CarManufacture manufacture, int waitTime);   
}
