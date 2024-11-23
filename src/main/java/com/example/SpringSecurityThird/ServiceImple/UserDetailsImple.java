package com.example.SpringSecurityThird.ServiceImple;

import com.example.SpringSecurityThird.model.UserSecurity;
import com.example.SpringSecurityThird.repositoriy.RepositoriyUserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDetailsImple implements UserDetailsService {
    @Autowired
    private RepositoriyUserSecurity repositoriyUserSecurity;

    // логика доставания пользователя из базы данных, достаю пользователя из базы данных и передаю провайдеру для сравнения
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSecurity byUserName = findByUserName(username);
        return new User(byUserName.getUserName(), byUserName.getPassword(), byUserName.getRole().getPermission().stream().
                map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toList()));
    }
    public UserSecurity findByUserName(String username){
        if (repositoriyUserSecurity.findByUserName(username).isPresent()){
            return  repositoriyUserSecurity.findByUserName(username).get();
        }
        throw new RuntimeException("такого пользователя  нет " + username);
    }
}
