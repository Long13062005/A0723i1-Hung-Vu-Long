package com.example.projectmyself.model;

public class Tutor {
    private int gvID;
    private String gvName;

    public int getGvID() {
        return gvID;
    }

    public void setGvID(int gvID) {
        this.gvID = gvID;
    }

    public String getGvName() {
        return gvName;
    }

    public void setGvName(String gvName) {
        this.gvName = gvName;
    }

    public Tutor() {
    }

    public Tutor(int gvID, String gvName) {
        this.gvID = gvID;
        this.gvName = gvName;
    }
}
