package com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.enums;

public enum HamburgerMenuOptions {
    HOME("Home"),
    NEWS("News"),
    REVIEWS("Reviews"),
    VIDEOS("Videos"),
    FEATURED("Featured"),
    PHONEFINDER("Phone Finder"),
    DEALS("Deals"),
    MERCH("Merch\nNew"),
    COVERAGE("Coverage"),
    CONTACT("Contact");

    private String name;

    HamburgerMenuOptions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
