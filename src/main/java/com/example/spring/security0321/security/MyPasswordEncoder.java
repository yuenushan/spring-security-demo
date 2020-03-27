package com.example.spring.security0321.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        String encode = DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
        return s.equals( encode );
    }
}

