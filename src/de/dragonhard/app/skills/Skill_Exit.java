package de.dragonhard.app.skills;

import java.awt.*;
import java.io.IOException;

public class Skill_Exit implements Skill {

    @Override
    public void initialize() throws IOException, AWTException {
        System.exit(0);
    }
}
