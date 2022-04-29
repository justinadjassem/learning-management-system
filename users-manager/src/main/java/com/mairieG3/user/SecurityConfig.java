package com.mairieG3.user;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("(member={0})")
                .contextSource()
                .root("dc=,dc=")
                .ldif("classpath:users.ldif");
    }
    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/home","/css/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().logoutSuccessUrl("/");
    }
}
