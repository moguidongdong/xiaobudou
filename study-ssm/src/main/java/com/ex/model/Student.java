package com.ex.model;

public class Student {
    private String id;

    private String name;

    private String birth;

    private String sex;

    public Student(String id, String name, String birth, String sex) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getSex() {
        return sex;
    }
}