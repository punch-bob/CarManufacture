package com.common.counted_values_strategy;

import com.common.publisher.ISubscriber;
import com.factory.CarManufacture;

public enum CountedValues implements ICountedValues
{
    AccessoryStorage
    {
        @Override
        public int getCount(CarManufacture manufacture) 
        {
            return manufacture.getCurrentAccessoryStorageCount();
        }

        @Override
        public void addSubscriber(CarManufacture manufacture, ISubscriber subscriber) 
        {
            manufacture.getAccessoryStorage().addSubscriber(subscriber);
        }    
    },

    BodyStorage
    {
        @Override
        public int getCount(CarManufacture manufacture) 
        {
            return manufacture.getCurrentBodyStorageCount();
        }

        @Override
        public void addSubscriber(CarManufacture manufacture, ISubscriber subscriber) 
        {
            manufacture.getMotorStorage().addSubscriber(subscriber);            
        }
    },

    MotorStorage
    {
        @Override
        public int getCount(CarManufacture manufacture)
        {
            return manufacture.getCurrentMotorStorageCount();
        }

        @Override
        public void addSubscriber(CarManufacture manufacture, ISubscriber subscriber) 
        {
            manufacture.getMotorStorage().addSubscriber(subscriber);
        }
    },

    CarStorage
    {
        @Override
        public int getCount(CarManufacture manufacture) 
        {
            return manufacture.getCurrentCarStorageCount();
        }

        @Override
        public void addSubscriber(CarManufacture manufacture, ISubscriber subscriber) 
        {
            manufacture.getCarStorage().addSubscriber(subscriber);
        } 
    },

    TotalCreatedAccessory
    {
        @Override
        public int getCount(CarManufacture manufacture) 
        {
            return manufacture.getAccessoryCounter().getCount();
        }

        @Override
        public void addSubscriber(CarManufacture manufacture, ISubscriber subscriber) 
        {
            manufacture.getAccessoryCounter().addSubscriber(subscriber);   
        } 
    },

    TotalCreatedBody
    {
        @Override
        public int getCount(CarManufacture manufacture) 
        {
            return manufacture.getBodyCounter().getCount();
        }

        @Override
        public void addSubscriber(CarManufacture manufacture, ISubscriber subscriber) 
        {
            manufacture.getBodyCounter().addSubscriber(subscriber);
        }
    },

    TotalCreatedMotor
    {
        @Override
        public int getCount(CarManufacture manufacture) 
        {
            return manufacture.getMotorCounter().getCount();
        }

        @Override
        public void addSubscriber(CarManufacture manufacture, ISubscriber subscriber)
        {
            manufacture.getMotorCounter().addSubscriber(subscriber);   
        }
    },

    SoldedCars
    {
        @Override
        public int getCount(CarManufacture manufacture) 
        {
            return manufacture.getSoldedCarsCounter().getCount();
        }

        @Override
        public void addSubscriber(CarManufacture manufacture, ISubscriber subscriber) 
        {
            manufacture.getSoldedCarsCounter().addSubscriber(subscriber);
        }
    };
}
