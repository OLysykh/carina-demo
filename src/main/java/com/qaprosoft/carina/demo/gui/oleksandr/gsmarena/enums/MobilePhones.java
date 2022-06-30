package com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.enums;

public enum MobilePhones {
    NOTHINGPHONE("Nothing phone"),
    PIXEL6PRO("Pixel 6 pro"),
    SAMSUNGS22("Samsung Galaxy S22 Ultra 5G"),
    APPLE("Apple iPhone 13 Pro Max"),
    XIAOMI("Xiaomi Black Shark 5 Pro");

    private String name;

    MobilePhones(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
