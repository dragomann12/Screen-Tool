package de.dragonhard.app.gui;



import de.dragonhard.app.Config;
import de.dragonhard.app.skills.Skill_Screenshot;
import de.dragonhard.app.components.Button;
import de.dragonhard.app.components.Label;
import de.dragonhard.app.skills.Skill_Exit;


import java.awt.*;
import java.util.ArrayList;

public class ScreenFrame {

    private static final ArrayList<Component> components = new ArrayList<>();
    public static final Frame frame = new Frame(Config.appName, Config.appWidth, Config.appHeight, components, new Color(70,70,70),true);


    public static void initialize(){

        Button btn_screenshot = new Button(
                "Screenshot",
                130,30,10,10,
                new Color(70,70,70),
                new Color(150,180,220),
                new Color(120,190,250),
                true,
                new Skill_Screenshot()
        );

        Button btn_settings = new Button(
                "Settings [Not in Alpha]",265,30,10,45,
                new Color(70,70,70),
                new Color(150,180,220),
                Color.white,
                false,
                null
        );

        Button btn_hotkeys = new Button(
                "Hotkeys [Not in Alpha]",130,30,145,10,
                new Color(70,70,70),
                new Color(150,180,220),
                Color.white,
                false,
                null
        );

        Button btn_exit = new Button(
                "Exit",265,35,10,80,
                new Color(70,70,70),
                Color.red,
                Color.red,
                true,
                new Skill_Exit()
        );

        Label lbl_version = new Label("Version: " + Config.appVersion,
                200,30,13,113,
                Color.orange,
                null
        );

        components.add(btn_screenshot.get());
        components.add(btn_hotkeys.get());
        components.add(btn_settings.get());
        components.add(btn_exit.get());
        components.add(lbl_version.get());

        frame.open();
    }

}
