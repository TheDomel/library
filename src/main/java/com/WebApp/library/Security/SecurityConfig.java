package com.WebApp.library.Security;

import com.WebApp.library.Service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    protected void configure(HttpSecurity http) throws Exception{

       http.csrf().disable();
       http.authorizeRequests().antMatchers("/library/**").hasAnyRole("ADMIN", "USER").anyRequest().fullyAuthenticated().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

//http.
//        csrf().disable()
//        .authorizeHttpRequests()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .antMatcher("/library/**")
//        .authorizeRequests(authorize -> authorize
//        .anyRequest().hasRole("USER")
//        )
//        .httpBasic();