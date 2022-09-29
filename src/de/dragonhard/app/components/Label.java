package de.dragonhard.app.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Label extends JLabel {

    private final String text;
    private final int width;
    private final int height;
    private final int x;
    private final int y;
    private final Color foreground;
    private final Font font;

    public Label(String text, int width, int height, int x, int y, Color foreground, Font font){

        this.text = text;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.foreground = foreground;
        this.font = font;
    }

    public JLabel get(){

        this.setText(text);
        this.setForeground(foreground);
        this.setBounds(x, y, width, height);

        if(font != null) {
            this.setFont(font);
        }

        return this;

    }
}
