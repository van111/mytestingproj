package com.example.fortydegreescelsius.textbased.Model;

/**
 * Created by FORTYDEGREESCELSIUS on 12/2/2016.
 */
public class Question {

    int id;
    String scene;
    String question;
    String chapter;

    public Question() {

    }

    public Question(String scene, String question, String chapter) {
        //this.id = id;
        this.scene = scene;
        this.question = question;
        this.chapter = chapter;
    }

    public int getID() {
        return this.id;
    }

    public String getScene() {
        return this.scene;
    }

    public String getQuestion() {
        return this.question;
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

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

}
