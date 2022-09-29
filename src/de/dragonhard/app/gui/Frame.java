package de.dragonhard.app.gui;

import de.dragonhard.app.components.Button;
import de.dragonhard.app.components.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Frame extends JFrame {

    private final String title;
    private final int width;
    private final int height;
    private final ArrayList<Component> components;
    private final Color background;
    private final boolean exitOnCLose;

    public Frame(String title, int width, int height, ArrayList<Component> components, Color background, boolean exitOnCLose){

        this.title = title;
        this.width = width;
        this.height = height;
        this.components = components;
        this.background = background;
        this.exitOnCLose = exitOnCLose;
    }

    public void open(){

        this.setTitle(title);
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel());

        var contentPane = this.getContentPane();

        if(exitOnCLose) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        contentPane.setBackground(background);
        this.setBackground(contentPane.getBackground());

        contentPane.setLayout(null);

        for(int i = 0; i < components.size(); i++){
                var currentItem = components.get(i);
                contentPane.add(currentItem);

        }

        this.setVisible(true);

    }

  public JFrame get(){
        return this;
  }
}
