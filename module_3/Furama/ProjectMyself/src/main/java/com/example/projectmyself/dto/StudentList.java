package com.example.projectmyself.dto;

public class StudentList {
    private int id;
    private String name;
    private String className;
    private String gvName;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGvName() {
        return gvName;
    }

    public void setGvName(String gvName) {
        this.gvName = gvName;
    }

    public StudentList() {
    }

    public StudentList(int id, String name, String className, String gvName) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.gvName = gvName;
    }
}
