package com.presenter;

import com.common.counted_values_strategy.CountedValues;
import com.common.publisher.ISubscriber;
import com.common.publisher.Publisher;
import com.common.task_strategy.TasksStrategy;
import com.factory.CarManufacture;

public class Presenter extends Publisher
{
    private CarManufacture manufacture;

    public Presenter(CarManufacture manufacture)
    {
        this.manufacture = manufacture;
    }

    public void setSpeed(TasksStrategy strategy, int waitTime)
    {
        strategy.setSpeed(manufacture, waitTime);
        publishNotify();
    }

    public int getNumberOfProducts(CountedValues value)
    {
        return value.getCount(manufacture);
    }

    public void setSubscriber(CountedValues publisher, ISubscriber subscriber)
    {
        publisher.addSubscriber(manufacture, subscriber);
    }
}
