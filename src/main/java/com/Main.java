package com;

import com.common.Configurator;
import com.factory.CarManufacture;
import com.presenter.Presenter;
import com.threadpool.Task;
import com.threadpool.Tasks;
import com.threadpool.ThreadPool;
import com.view.MainDrawer;

public final class Main 
{
    public static void main(String[] args) 
    {
        Configurator configurator = new Configurator();
        CarManufacture manufacture = new CarManufacture(configurator);
        int totalThreads = configurator.getAccessorySuppliers() + configurator.getBodySuppliers() + configurator.getMotorSuppliers() + 
                           configurator.getDealers() + configurator.getWorkers();

        ThreadPool threadPool = new ThreadPool(totalThreads);

        Tasks tasks = new Tasks(manufacture.getAccessorySuppliers().getSuppliersList(), manufacture.getBodySuppliers().getSuppliersList(), 
                                manufacture.getMotorSuppliers().getSuppliersList(), manufacture.getDealers().getDealersList(), 
                                manufacture.getWorkers().getWorkersList());
        for (Task task : tasks.getTasksList())
        {
            threadPool.addTask(task);
        }

        Presenter presenter = new Presenter(manufacture);
        MainDrawer GUI = new MainDrawer(presenter);
        GUI.setVisible(true);
    }
}
