package com.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.common.counted_values_strategy.CountedValues;
import com.common.publisher.ISubscriber;
import com.presenter.Presenter;

public class NumberOfProductsPanel extends JPanel implements ISubscriber
{
    private Presenter presenter;
    private String name;
    private CountedValues currentValue;
    private CountedValues totalValue;
    private JLabel currentState;
    private JLabel totalUsed;

    public NumberOfProductsPanel(String name, Presenter presenter, CountedValues currentValue, CountedValues totalValue)
    {
        super();
        this.name = name;
        this.presenter = presenter;
        this.currentValue = currentValue;
        this.totalValue = totalValue;
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        currentState = new JLabel(name + " in storage: <" + presenter.getNumberOfProducts(currentValue) + ">");
        totalUsed = new JLabel(name + " total produced: <" + presenter.getNumberOfProducts(totalValue) + ">");

        presenter.setSubscriber(currentValue, this);
        presenter.setSubscriber(totalValue, this);
        this.add(Box.createRigidArea(new Dimension(20, 20)));
        this.add(currentState);
        this.add(totalUsed);
    }

    @Override
    public void reactOnNotify() 
    {
        currentState.setText(name + " in storage: <" + presenter.getNumberOfProducts(currentValue) + ">");
        totalUsed.setText(name + " total produced: <" + presenter.getNumberOfProducts(totalValue) + ">");
    }
}
