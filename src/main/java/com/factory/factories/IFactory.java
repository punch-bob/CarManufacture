package com.factory.factories;

import com.factory.product.Accessory;
import com.factory.product.Body;
import com.factory.product.Motor;
import com.factory.product.Product;

public interface IFactory<T extends Product>
{
    T create();
    T create(Accessory accessory, Body body, Motor motor);
}
