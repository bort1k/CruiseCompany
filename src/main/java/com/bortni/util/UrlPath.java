package com.bortni.util;

public enum UrlPath {
    HOME("/home"),
    OUR_SHIPS("/our-ships"),
    OUR_CRUISES("/our-cruises"),
    ABOUT_US("/about-us"),
    SHIP_ITEM("/ship-item"),
    CRUISE_ITEM("/cruise-item"),
    SIGN_UP_PAGE("/sign-up-page"),
    SIGN_IN_PAGE("/sign-in-page"),
    SIGN_UP("/sign-up"),
    SIGN_IN("/sign-in"),
    LOG_OUT("/log-out"),
    USER_PROFILE("/user-profile"),
    ADMIN("/admin")
    ;

    private final String path;

    UrlPath(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
