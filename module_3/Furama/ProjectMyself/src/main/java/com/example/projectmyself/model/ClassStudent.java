package com.example.projectmyself.model;

public class ClassStudent {
    private int classID;
    private String className;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ClassStudent() {
    }

    public ClassStudent(int classID, String className) {
        this.classID = classID;
        this.className = className;
    }
}
