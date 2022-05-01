package com.common.task_strategy;

import com.factory.CarManufacture;

public enum TasksStrategy implements ITaskStrategy
{
    AccessorySuppliers
    {
        @Override
        public void setSpeed(CarManufacture manufacture, int waitTime) 
        {
            manufacture.getAccessorySuppliers().setWaitTime(waitTime);
        }
    },

    BodySuppliers
    {
        @Override
        public void setSpeed(CarManufacture manufacture, int waitTime) 
        {
            manufacture.getBodySuppliers().setWaitTime(waitTime);
        }
    },

    MotorSuppliers
    {
        @Override
        public void setSpeed(CarManufacture manufacture, int waitTime) 
        {
           manufacture.getMotorSuppliers().setWaitTime(waitTime);
        }
    },

    Dealers
    {
        @Override
        public void setSpeed(CarManufacture manufacture, int waitTime) 
        {
            manufacture.getDealers().setWaitTime(waitTime);
        }
    };
}
