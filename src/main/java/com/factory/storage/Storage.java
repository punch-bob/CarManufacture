package com.factory.storage;

import java.util.LinkedList;
import java.util.Queue;

import com.common.publisher.Publisher;
import com.factory.product.Product;

public class Storage<T extends Product> extends Publisher implements IStorage<T>
{
    private int maxSize;
    private Queue<T> queue;

    public Storage(int maxSize)
    {
        this.maxSize = maxSize;
        queue = new LinkedList<>();
    }

    @Override
    public int getNumberOfProduct() 
    {
        return queue.size();
    }

    @Override
    public boolean isEmpty() 
    {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() 
    {
        return (maxSize == queue.size());
    }

    @Override
    public synchronized void addProduct(T product) 
    {
        if(!isFull())
        {
            queue.add(product);
            notify();
            publishNotify();
        }
        else
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized T getProduct()
    {
        while (true)
        {
            if (!isEmpty())
            {
                T product = queue.remove();
                notify();
                publishNotify();
                return product;
            }
            else 
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
