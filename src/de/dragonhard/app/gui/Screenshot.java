package de.dragonhard.app.gui;

import de.dragonhard.app.Config;
import de.dragonhard.app.components.Label;

import java.awt.*;
import java.util.ArrayList;

public class Screenshot {

    private static final ArrayList<Component> components = new ArrayList<>();

    public static final Frame frame = new Frame("Screenshot",
            Toolkit.getDefaultToolkit().getScreenSize().width,
            Toolkit.getDefaultToolkit().getScreenSize().height,
            components,
            new Color(70,70,70,0),
            true
    );


    public static void initialize(String creator){

        frame.setAutoRequestFocus(true);
        frame.setUndecorated(true);
        frame.setFocusable(true);
        frame.setFocusableWindowState(true);


        Label credits = new Label("Screenshot created by " + creator,
                350,20,Toolkit.getDefaultToolkit().getScreenSize().width -350,5,
                Color.orange,new Font("BOLD", 5, 16)
        );

        if(Config.showCreatorInfo) {
            components.add(credits.get());
        }

        frame.open();

    }

    public static void close(){
        frame.dispose();
    }
}
