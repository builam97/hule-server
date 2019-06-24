package com.example.demo.security;

public class TokenAuthenticationService {
	static final long EXPIRATION_TIME = 864_000_000;
	static final String SECRET = "ThisIsSecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";

}
