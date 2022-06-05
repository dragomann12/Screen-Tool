package de.dragonhard.app;

import de.dragonhard.app.gui.ScreenFrame;
import de.dragonhard.app.skills.Skill;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

    private static final ArrayList<Skill> skills = new ArrayList<>();
    private static final HashMap<String, JFrame> screens = new HashMap<>();

    public static void register(Skill skill){
        if(exists(skill)){ System.err.println("[SKILL] the Skill with id: " + skill.id() + " already exists!"); return;}
        skills.add(skill);
    }

    public static Skill getSkill(String id){
        if(!exists(id)){return null;}
        return skills.get(getIndexOfSkill(id));
    }

    public static void register(String key, JFrame frame){
        screens.put(key, frame);
    }

    public static JFrame getScreen(String key){
        return screens.get(key);
    }

    private static int getIndexOfSkill(String id){
        var index = 0;

        for (int i = 0; i < skills.size(); i++){

            if(id.equals(skills.get(i).id())){
                index = i;
            }

        }

        return index;
    }

    public static Boolean exists(Skill skill){

        for (int i = 0; i < skills.size(); i++){

            if(skill.id().equals(skills.get(i).id())){
                return true;
            }

        }

        return false;

    }

    public static Boolean exists(String id){

        for (int i = 0; i < skills.size(); i++){

            if(id.equals(skills.get(i).id())){
                return true;
            }

        }

        return false;

    }

}
