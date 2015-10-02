package com.portablemind.configuration;

import javax.inject.Inject;
import javax.sql.DataSource;

import com.portablemind.user.UserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Import( {HibernateConfiguration.class} )
@ComponentScan("com.portablemind")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Inject
    DataSource dataSource;

    @Inject
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Inject
    public void configAuthentication(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {

        auth.userDetailsService(userDetailsServiceImpl)
                .passwordEncoder(passwordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/board/*").authenticated()
            .antMatchers("/project/*").authenticated()
            .antMatchers("/cardCategory/**").authenticated()
            .antMatchers("/cardType/**").authenticated()
                .and()
              .formLogin().loginPage("/user/login").failureUrl("/user/login?error")
              .usernameParameter("mail").passwordParameter("password")
            .and()
               .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/")
            .and()
              .exceptionHandling().accessDeniedPage("/403")
            .and()
              .csrf();
    }
}