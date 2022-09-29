package de.dragonhard.app.components;

import de.dragonhard.app.skills.Skill;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class Button extends JButton {

    private final String text;
    private final int width;
    private final int height;
    private final int x;
    private final int y;
    private final Color background;
    private final Color foreground;
    private final Color border;
    private final boolean enabled;
    private Object skill;

    public Button(String text, int width, int height, int x, int y, Color background, Color foreground, Color border, boolean enabled, Object skill){

        this.text = text;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.background = background;
        this.foreground = foreground;
        this.border = border;
        this.enabled = enabled;
        this.skill = skill;
    }

    public JButton get(){
        var button= this;
        this.setText(text);
        this.setFocusable(false);
        this.setBorder(new LineBorder(border));
        this.setBackground(background);
        this.setEnabled(enabled);
        this.setForeground(foreground);
        this.setBounds(x,y,width,height);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.gray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(background);
            }
        });

        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                var action = (Skill) skill;

                try {
                    action.initialize();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }

            }
        });

        return this;
    }

}
