package com.view;

import javax.swing.JFrame;

import com.common.counted_values_strategy.CountedValues;
import com.common.task_strategy.TasksStrategy;
import com.presenter.Presenter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class MainDrawer extends JFrame
{
    public MainDrawer(Presenter presenter)
    {
        super("CAR MANUFACTURE");
        setIconImage();
        setFrame();

        SpeedSliderPanel accessorySlider = new SpeedSliderPanel("Accessory", presenter, TasksStrategy.AccessorySuppliers);
        SpeedSliderPanel bodySlider = new SpeedSliderPanel("Body", presenter, TasksStrategy.BodySuppliers);
        SpeedSliderPanel motorSlider = new SpeedSliderPanel("Motor", presenter, TasksStrategy.MotorSuppliers);
        SpeedSliderPanel dealerSlider = new SpeedSliderPanel("Dealer", presenter, TasksStrategy.Dealers);

        NumberOfProductsPanel accessoryPanel = new NumberOfProductsPanel("Accessories", presenter, CountedValues.AccessoryStorage, CountedValues.TotalCreatedAccessory);
        NumberOfProductsPanel bodyPanel = new NumberOfProductsPanel("Bodies", presenter, CountedValues.BodyStorage, CountedValues.TotalCreatedBody);
        NumberOfProductsPanel motorPanel = new NumberOfProductsPanel("Motors", presenter, CountedValues.MotorStorage, CountedValues.TotalCreatedMotor);
        NumberOfProductsPanel carPanel = new NumberOfProductsPanel("Cars", presenter, CountedValues.CarStorage, CountedValues.SoldedCars);

        this.add(accessorySlider);
        this.add(bodySlider);
        this.add(motorSlider);
        this.add(dealerSlider);

        this.add(accessoryPanel);
        this.add(bodyPanel);
        this.add(motorPanel);
        this.add(carPanel);
    }

    private void setIconImage()
    {
        ImageIcon icon = new ImageIcon("src/main/resources/car_manufacture.png");
        this.setIconImage(icon.getImage());
    }

    private void setFrame()
    {
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setSize(520, 520);
    }
}
