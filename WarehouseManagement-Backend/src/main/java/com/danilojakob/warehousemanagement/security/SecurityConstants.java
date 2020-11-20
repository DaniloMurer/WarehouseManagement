package com.danilojakob.warehousemanagement.security;
/**
 * Security Constants
 * @copyright Danilo Jakob
 */
public interface SecurityConstants {
    /**
     * Secret for the encryption of the JWT Token
     * THIS SECRET MUST BE CHANGED!!!
     */
    String SECRET = "t48ggap884jgnv0ö$fadsjkljö12";
    /**
     * Expiration Date for the JWT Token, set for 10 Days
     */
    long EXPIRATION_DATE = 864_000_000;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
    String SING_UP_URL = "/user/signup";
    String LOGIN_URL = "/login";
}
