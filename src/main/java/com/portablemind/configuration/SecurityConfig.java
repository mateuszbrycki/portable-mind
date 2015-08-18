package com.portablemind.configuration;

/**
 * Created by Mateusz Brycki on 27/05/2015.
 */

import javax.sql.DataSource;

import com.portablemind.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Import( {HibernateConfiguration.class} )
@ComponentScan("com.portablemind")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceImpl);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/cardCategory/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
            .antMatchers("/cardType/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .and()
              .formLogin().loginPage("/user/login").failureUrl("/user/login?error")
              .usernameParameter("mail").passwordParameter("password")
            .and()
               .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/user/logout")
            .and()
              .exceptionHandling().accessDeniedPage("/403")
            .and()
              .csrf();
    }
}