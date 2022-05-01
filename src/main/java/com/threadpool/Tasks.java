package com.threadpool;

import java.util.ArrayList;

import com.factory.dealer.Dealer;
import com.factory.product.Accessory;
import com.factory.product.Body;
import com.factory.product.Motor;
import com.factory.supplier.Supplier;
import com.factory.worker.Worker;

public class Tasks 
{
    private ArrayList<Task> tasksList = new ArrayList<>();

    public Tasks(ArrayList<Supplier<Accessory>> accessorySuppliersList, ArrayList<Supplier<Body>> bodySuppliersList,
                 ArrayList<Supplier<Motor>> motorSuppliersList, ArrayList<Dealer> dealersList, ArrayList<Worker> workersList)
    {
        tasksList.addAll(accessorySuppliersList);
        tasksList.addAll(bodySuppliersList);
        tasksList.addAll(motorSuppliersList);
        tasksList.addAll(dealersList);
        tasksList.addAll(workersList);
    }

    public ArrayList<Task> getTasksList()
    {
        return tasksList;
    }
}
