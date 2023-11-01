package com.example;

public class MemberInfo {

    private String id;
    private String name;
    private String email;
    private boolean male;
    private int age;

    public MemberInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
