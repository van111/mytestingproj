package com.example.fortydegreescelsius.textbased.Model;

/**
 * Created by FORTYDEGREESCELSIUS on 1/25/2017.
 */
public class User {

    int id;
    String scene;
    String username;
    String chapter;

    public User() {

    }

    public User(String scene, String username, String chapter) {
        this.scene = scene;
        this.username = username;
        this.chapter = chapter;
    }

    public int getID() {
        return this.id;
    }

    public String getScene() {
        return this.scene;
    }

    public String getUsername() {
        return this.username;
    }

    public String getChapter() {
        return this.chapter;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
