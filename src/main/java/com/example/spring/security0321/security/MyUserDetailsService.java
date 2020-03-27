package com.example.spring.security0321.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Map<String, UserDetails> map = new HashMap<>();

    @PostConstruct
    public void init() {
        map.put("admin", new User("admin", passwordEncoder.encode("admin"), Collections.singleton(new SimpleGrantedAuthority("admin"))));
        map.put("employee", new User("employee", passwordEncoder.encode("employee"), Collections.singleton(new SimpleGrantedAuthority("employee"))));
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return map.get(userName);
    }
}
