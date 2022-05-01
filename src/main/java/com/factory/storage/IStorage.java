package com.factory.storage;

import com.factory.product.Product;

public interface IStorage<T extends Product>
{
    public int getNumberOfProduct();
    public boolean isEmpty();
    public boolean isFull();
    public void addProduct(T product);
    public T getProduct() throws InterruptedException;
}
