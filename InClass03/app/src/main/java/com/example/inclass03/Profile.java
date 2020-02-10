package com.example.inclass03;

// InClass#03
// Profile.java
// Akshay Popli and Neel Solanki
// Assignment Group #14

import java.io.Serializable;

public class Profile implements Serializable {
    String f_name;
    String l_name;
    String selected_gender;

    public Profile(String f_name, String l_name, String selected_gender) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.selected_gender = selected_gender;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", selected_gender=" + selected_gender +
                '}';
    }
}
