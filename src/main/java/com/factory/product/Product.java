package com.factory.product;

public class Product implements IProduct
{
    private String VIN;

    public Product(String VIN)
    {
        this.VIN = VIN;
    }

    @Override
    public String getVIN() 
    {
        return VIN;
    }
    
}
