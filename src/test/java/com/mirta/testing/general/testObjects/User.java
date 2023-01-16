package com.mirta.testing.general.testObjects;

import com.mirta.testing.common.Generator;

public class User {

    public String name, surname, middleName;

    public User(String name, String surname, String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    public User() {
    }

    public User generateValidUser(){
        this.name = Generator.latinString(10);
        this.surname = Generator.latinString(10);
        this.middleName = Generator.latinString(10);
        return this;
    }
}
