package de.dragonhard.app.gui;

import javax.swing.*;
import java.awt.*;

public class Screenshot {

    private static final JFrame frame = new JFrame();
    private static final JPanel contentPane = new JPanel();
    private static final JLabel lblCredits = new JLabel();


    public static void initialize(String title, String credits){

        frame.setTitle(title);
        frame.setContentPane(contentPane);
        frame.setUndecorated(true);
        frame.setBounds(0,0,1920,1200);
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(250,250,250,1));

        contentPane.setBackground(frame.getBackground());
        contentPane.setLayout(null);

        lblCredits.setText(credits);
        lblCredits.setFont(new Font("BOLD",4,16));
        lblCredits.setBackground(new Color(0,0,0,20));
        lblCredits.setBounds(1500,10,300,20);
        lblCredits.setForeground(Color.orange);

        contentPane.add(lblCredits);

        frame.setVisible(true);
    }

    public static void close(){
        frame.dispose();
    }
}
