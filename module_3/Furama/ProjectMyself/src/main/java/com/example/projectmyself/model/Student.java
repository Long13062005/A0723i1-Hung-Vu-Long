package com.example.projectmyself.model;

public class Student {
    private int id;
    private String name;
    private int classID;
    private int gvID;

    public Student(String name, int classID, int gvID) {
        this.name = name;
        this.classID = classID;
        this.gvID = gvID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getGvID() {
        return gvID;
    }

    public void setGvID(int gvID) {
        this.gvID = gvID;
    }

    public Student() {
    }

    public Student(int id, String name, int classID, int gvID) {
        this.id = id;
        this.name = name;
        this.classID = classID;
        this.gvID = gvID;
    }
}
