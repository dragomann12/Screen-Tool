package de.dragonhard.app;

import de.dragonhard.app.gui.ScreenFrame;
import de.dragonhard.app.skills.Skill_Screenshot;

public class Main {

    public static void main(String[] args){
        Manager.register(new Skill_Screenshot());
        ScreenFrame.initialize();


    }
}
