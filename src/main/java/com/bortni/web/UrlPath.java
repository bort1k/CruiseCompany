package com.bortni.web;

public enum UrlPath {
    HOME("/home"),
    OUR_SHIPS("/our-ships"),
    OUR_CRUISES("/our-cruises"),
    ABOUT_US("/about-us"),
    SHIP_ITEM("/ship-item"),
    CRUISE_ITEM("/cruise-item"),
    SIGN_UP("/sign-up"),
    SIGN_IN("/sign-in"),
    SIGN_UP_USER("/sign-up-user"),
    SIGN_IN_USER("/sign-in-user"),
    LOG_OUT("/log-out"),
    USER_PROFILE("/user-profile"),
    ;

    private final String path;

    UrlPath(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
