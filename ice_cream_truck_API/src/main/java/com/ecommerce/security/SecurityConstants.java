package com.ecommerce.security;

public class SecurityConstants {
    public static final String LOGIN_URL = "/login"; 
    public static final String SIGN_UP_URL = "/users/record";
    public static final String BUY_URL = "/truck/buy";
    public static final String CHECK_URL = "/truck/checkInventory";
    public static final String ADD_URL = "/truck/addInventory";
    public static final String ADD_ITEM_URL = "/truck/addItem";
    public static final String DELETE_ITEM_URL = "/truck/deleteItem";
    public static final String CHANGE_URL = "/truck/changePrice";
    public static final String GET_NET_URL = "/truck/getNet";

    public static final String KEY = "q3t6w9z$C&F)J@NcQfTjWnZr4u7x!A%D*G-KaPdSgUkXp2s5v8y/B?E(H+MbQeTh";
    public static final String HEADER_NAME = "Authorization";
    public static final Long EXPIRATION_TIME = 1000L*60*30;
}