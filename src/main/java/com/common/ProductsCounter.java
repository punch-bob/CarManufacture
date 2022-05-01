package com.common;

import com.common.publisher.Publisher;
import com.factory.product.Product;

public class ProductsCounter<T extends Product> extends Publisher
{
    private int count = 0;

    public void increment()
    {
        ++count;
        publishNotify();
    }

    public int getCount()
    {
        return count;
    }
}
