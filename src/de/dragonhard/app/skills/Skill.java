package de.dragonhard.app.skills;

import java.awt.*;
import java.io.IOException;

public interface Skill {

    String id();
    String version();
    void initialize() throws IOException, AWTException;
}
