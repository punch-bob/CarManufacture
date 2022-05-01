package com.factory.supplier;

import java.util.ArrayList;

import com.common.ProductsCounter;
import com.factory.factories.IFactory;
import com.factory.product.Product;
import com.factory.storage.Storage;

public class Suppliers<T extends Product>
{
    private ArrayList<Supplier<T>> suppliersList = new ArrayList<>();

    public Suppliers(int totalSuppliers, Storage<T> storage, IFactory<T> factory, ProductsCounter<T> counter)
    {
        for (int i = 0; i < totalSuppliers; ++i)
        {
            suppliersList.add(new Supplier<>(storage, factory, counter, 1000));
        }
    }

    public ArrayList<Supplier<T>> getSuppliersList()
    {
        return suppliersList;
    }

    public void setWaitTime(int waitTime) 
    {
        for (Supplier<T> supplier : suppliersList)
        {
            supplier.setWaitTime(waitTime);
        }   
    }
}
