package de.dragonhard.app.skills;

import de.dragonhard.app.gui.ScreenFrame;
import de.dragonhard.app.gui.Screenshot;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Skill_Screenshot implements Skill{

    private SimpleDateFormat formatter = new SimpleDateFormat("wwwhhmmss dd.MM.yyyy");
    BufferedImage screenShot;
    Calendar now;

    @Override
    public void initialize() throws IOException, AWTException {
        JFrame frame = ScreenFrame.frame.get();
        frame.setState(1);
        Robot robot = new Robot();

        now = Calendar.getInstance();

        Screenshot.initialize(System.getProperty("user.name"));

        screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", new File("C:\\Users\\" + System.getProperty("user.name") + "\\Pictures\\"+ formatter.format(now.getTime())+".jpg"));

        System.out.println("[Screenshot] " + formatter.format(now.getTime()) + " created");
        Screenshot.close();
        frame.setState(0);

    }
}
