package com.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.common.publisher.ISubscriber;
import com.common.task_strategy.TasksStrategy;
import com.presenter.Presenter;

public class SpeedSliderPanel extends JPanel implements ISubscriber
{
    private JSlider slider;
    private JLabel label;
    private String name;

    public SpeedSliderPanel(String name, Presenter presenter, TasksStrategy strategy)
    {
        super();
        this.name = name;
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        slider = new JSlider(0, 15, 1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);

        label = new JLabel(name + ": <"+ slider.getValue() + "> seconds");

        slider.addChangeListener(new ViewController(presenter, strategy));

        presenter.addSubscriber(this);

        this.add(Box.createRigidArea(new Dimension(20, 20)));
        this.add(label);
        this.add(slider);
    }

    @Override
    public void reactOnNotify() 
    {
        label.setText(name + ": <"+ slider.getValue() + "> seconds");
    }
}
