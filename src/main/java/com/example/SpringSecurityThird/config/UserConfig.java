package com.example.SpringSecurityThird.config;

import com.example.SpringSecurityThird.ServiceImple.UserDetailsImple;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class UserConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsImple userDetailsImple;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/clothe/add")
                .hasAnyAuthority("read","write")
                .antMatchers("/api/clothe/findclothe")
                .permitAll()
                .antMatchers("/api/clothe/deleteclothe/**")
                .hasAuthority("write")
                .antMatchers("/api/usersecurity/registrsave")
                .permitAll()
                .antMatchers("/api/usersecurity/login")
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .logout()
                .logoutUrl("/api/logout")// кнопка для выхода
                .logoutSuccessUrl("/api/usersecurity/login") // переход на метод логин(выбор пользователя)
                .invalidateHttpSession(true)// удаляем прошлую сесию
                .clearAuthentication(true); // очищаем аутентификацию
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //наш сверщик
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsImple);
        return daoAuthenticationProvider;
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
