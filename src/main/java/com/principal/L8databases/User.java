package com.principal.L8databases;


public class User {
    private int userId;
    private String name;
    private int age;
    private String country;

    public User(int userId, String name, int age, String country) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public User(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
