package com.factory.product;

public class Car extends Product
{
    private Accessory accessory;
    private Body body;
    private Motor motor;

    public Car(Accessory accessory, Body body, Motor motor, String VIN)
    {
        super(VIN);
        this.accessory = accessory;
        this.body = body;
        this.motor = motor;
    }

    public Accessory getAccessory()
    {
        return accessory;
    }

    public Body getBody()
    {
        return body;
    }

    public Motor getMotor()
    {
        return motor;
    }
}
