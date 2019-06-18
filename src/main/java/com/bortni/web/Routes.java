package com.bortni.web;

public enum Routes {
    HOME("/jsp/home.jsp"),
    OUR_SHIPS("/jsp/our-ships.jsp"),
    OUR_CRUISES("/jsp/our-cruises.jsp"),
    ABOUT_US("/jsp/about-us.jsp"),
    SHIP_ITEM("/jsp/ship-item.jsp"),
    CRUISE_ITEM("/jsp/cruise-item.jsp"),
    SIGN_UP("/jsp/sign-up.jsp"),
    SIGN_IN("/jsp/sign-in.jsp"),
    USER_PROFILE("/jsp/user-profile.jsp"),
    ;

    private final String path;

    Routes(String path) {
        this.path = path;
    }

    public String getRoute() {
        return this.path;
    }
}
