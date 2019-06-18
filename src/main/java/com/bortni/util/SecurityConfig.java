package com.bortni.util;

import com.bortni.model.enums.Role;

import java.util.*;

public class SecurityConfig {
    private static final Map<Role, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init(){

        List<String> userUrlPatterns = new ArrayList<>();
        userUrlPatterns.add(UrlPath.USER_PROFILE.getPath());
        mapConfig.put(Role.USER, userUrlPatterns);

        List<String> adminUrlPatterns = new ArrayList<>();
        adminUrlPatterns.add(UrlPath.ADMIN.getPath());
        adminUrlPatterns.add(UrlPath.USER_PROFILE.getPath());
        mapConfig.put(Role.ADMIN, adminUrlPatterns);

    }

    public static Set<Role> getAllAppRoles(){
        return mapConfig.keySet();
    }

    public static List<String> getAllUrlPatternsForRole(Role role){
        return mapConfig.get(role);
    }
}
