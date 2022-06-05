package de.dragonhard.app.skills;

import de.dragonhard.app.Manager;
import de.dragonhard.app.gui.Screenshot;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Skill_Screenshot implements Skill{

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
    BufferedImage screenShot;
    Calendar now;

    @Override
    public String id() {
        return "Screen_Capture";
    }

    @Override
    public String version() {
        return "0.05 Pre Alpha";
    }

    @Override
    public void initialize() throws IOException, AWTException {
        JFrame frame = Manager.getScreen("Screen");
        frame.setState(1);
        Robot robot = new Robot();

        now = Calendar.getInstance();
        Screenshot.initialize("Screenshot | " + formatter.format(now.getTime()),"Screenshot created by " + System.getProperty("user.name"));
        screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        ImageIO.write(screenShot, "JPG", new File("C:\\Users\\" + System.getProperty("user.name") + "\\Pictures\\"+formatter.format(now.getTime())+".jpg"));
        System.out.println("[Screenshot] " + formatter.format(now.getTime()) + " created");
        Screenshot.close();

    }
}
