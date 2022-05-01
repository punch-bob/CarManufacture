package com.view;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.common.task_strategy.TasksStrategy;
import com.presenter.Presenter;

public class ViewController implements ChangeListener
{
    private Presenter presenter;
    private TasksStrategy strategy;

    public ViewController(Presenter presenter, TasksStrategy strategy)
    {
        super();
        this.presenter = presenter;
        this.strategy = strategy;
    }

    @Override
    public void stateChanged(ChangeEvent e) 
    {
        int waitTime = ((JSlider)e.getSource()).getValue() * 1000;
        presenter.setSpeed(strategy, waitTime);
    }   
}
