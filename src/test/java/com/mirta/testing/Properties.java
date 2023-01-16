package com.mirta.testing;

import java.util.ArrayList;

public enum Properties {

    // по умолчанию настройки сначала грузятся из сиcтемы. А потом уже отсюда.
    // если значение задано, оно будет установлено. Для игнорирования значения следует оставить его пустым - ""

    browser("chrome"), // браузер по умолчанию chrome, firefox, opera
    startMaximized("true"), // true false
    testInstanceDestination("local"),
    // ^ расположение машины (инстанса), где запукаются тесты - local - локальный пк, selenoid - селеноид
    selenoidAddress("http://"),
    selenoidPort(""),

    // Selenoid capabilities:
    enableVideo("false"),
    enableVNC("false"),

    showStartupLogs("false"), // true false

    elementsWaitTimeout("4000") // ms to wait elements
    ;

    public String val;

    Properties(String val) {
        this.val = val;
    }

    public ArrayList<String> getNames() {
        Properties[] states = values();
        ArrayList<String> names = new ArrayList<>();
        for (Properties state : states) {
            names.add(state.name());
        }
        return names;
    }
}
