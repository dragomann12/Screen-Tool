package de.dragonhard.app.gui;

import de.dragonhard.app.Config;
import de.dragonhard.app.Manager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class ScreenFrame {
    private static JFrame frame = new JFrame();
    private static ArrayList<JButton> buttons = new ArrayList<>();
    private static JLabel lblVersion = new JLabel();
    private static JPanel contentPane = new JPanel();
    private static void addButton(String text, String id, int width, int height, int x, int y, Color background, Color foreground, Color border, boolean isEnabled){

        JButton button = new JButton();

        button.setText(text);
        button.setFocusable(false);
        button.setBorder(new LineBorder(border));
        button.setBackground(background);
        button.setEnabled(isEnabled);
        button.setForeground(foreground);
        button.setBounds(x,y,width,height);
        button.addMouseListener(new MouseListener() {
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(button.getText().equals("Exit")){System.exit(0);return; }
                    Manager.getSkill(id).initialize();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }
            }
        });
        buttons.add(button);

    }

    public static void initialize(){

        frame.setTitle(Config.appName);
        frame.setSize(300,180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(contentPane);

        contentPane.setBackground(new Color(70,70,70));
        contentPane.setLayout(null);

        lblVersion.setText("Version: " + Config.appVersion);
        lblVersion.setForeground(Color.orange);
        lblVersion.setBounds(15,113,200,30);

        contentPane.add(lblVersion);

        addButton("Screenshot","Screen_Capture",130,30,10,10,
                new Color(70,70,70),
                new Color(150,180,220),
                new Color(120,190,250),
                true
        );

        addButton("Hotkeys [Not in Alpha]","",130,30,145,10,
                new Color(70,70,70),
                new Color(150,180,220),
                Color.white,
                false
        );

        addButton("Settings [Not in Alpha]","",265,30,10,45,
                new Color(70,70,70),
                new Color(150,180,220),
                Color.white,
                false
        );

        addButton("Exit","",265,35,10,80,
                new Color(70,70,70),
                Color.red,
                Color.red,
                true
        );

        for(int i = 0; i < buttons.size(); i++){
            contentPane.add(buttons.get(i));
        }

        frame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                frame.setFocusTraversalKeysEnabled(true);
                frame.setAutoRequestFocus(true);
                frame.setState(0);
            }
        });

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
               if(e.getKeyCode() == 112){
                   try {
                       Manager.getSkill("Screen_Capture").initialize();
                   } catch (IOException ex) {
                       ex.printStackTrace();
                   } catch (AWTException ex) {
                       ex.printStackTrace();
                   }
               }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        Manager.register(frame.getTitle(), frame);

        frame.setVisible(true);
    }

}
