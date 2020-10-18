package com.example.springbootsecurity.constants;

public class OAuth2Constant {

    public static final String RESOURCE_ID = "oauth2-resource";
    public static final String CLIENT_ID = "client-id";
    public static final String CLIENT_SECRET = "secret";
    public static final String GRANT_TYPE_PASSWORD = "password";
    public static final String AUTHORIZATION_CODE = "authorization_code";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String IMPLICIT = "implicit";
    public static final String SCOPE_READ = "read";
    public static final String SCOPE_WRITE = "write";
    public static final String SCOPE_TRUST = "trust";
    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
    public static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;
}
