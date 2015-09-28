package com.portablemind.user;

import com.portablemind.rest.api.UrlSpace;

/**
 * Created by Mateusz on 27.09.2015.
 */
public class UserUrls implements UrlSpace {
    public static final String USER = "/user";

    public static final String USER_LOGIN =  "/login";
    public static final String USER_LOGOUT = "/logout";
    public static final String USER_REGISTER = "/register";

    public static final String USER_LOGIN_FORM = USER + USER_LOGIN;
    public static final String USER_REGISTER_FORM = USER + USER_REGISTER;
}
