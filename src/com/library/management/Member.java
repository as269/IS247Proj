package com.library.management;

import java.util.ArrayList;

public class Member {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member {name='" + name + "'}";
    }
}