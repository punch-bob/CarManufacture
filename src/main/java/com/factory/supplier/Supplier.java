package com.factory.supplier;

import com.common.ProductsCounter;
import com.factory.factories.IFactory;
import com.factory.product.Product;
import com.factory.storage.Storage;
import com.threadpool.Task;

public class Supplier<T extends Product> implements Task
{
    private Storage<T> storage;
    private IFactory<T> factory;
    private ProductsCounter<T> counter;
    private int waitTime;

    public Supplier(Storage<T> storage, IFactory<T> factory, ProductsCounter<T> counter, int waitTime)
    {
        super();
        this.storage = storage;
        this.factory = factory;
        this.counter = counter;
        this.waitTime = waitTime;
    }

    @Override
    public void performWork() throws InterruptedException 
    {
        while(true)
        {
            storage.addProduct(factory.create());
            counter.increment();
            Thread.sleep(waitTime);
        }
    }

    public void setWaitTime(int waitTime)
    {
        this.waitTime = waitTime;
    }
}
