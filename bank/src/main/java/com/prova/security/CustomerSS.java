package com.prova.security;

import com.prova.domains.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomerSS implements UserDetails {


    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public  CustomerSS(Person customer){
        this.username = customer.getEmail();
        this.password = customer.getPassword();
        this.authorities = customer.getPersonType().stream()
                .map(x -> new SimpleGrantedAuthority(x.getPersonType())).collect(Collectors.toSet());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return username;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}
