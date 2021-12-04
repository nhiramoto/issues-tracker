package com.hiramoto.issuestracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("ZKb5hQsKW6TipC"))
                .roles("USER", "ADMIN")
                ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .anyRequest().permitAll()
            /*
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").authenticated()
            .antMatchers("/anonymous/**").anonymous()
            .antMatchers("/public/**").permitAll()
            .antMatchers("/static/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login.jsp")
            .loginProcessingUrl("/perform_login")
            .defaultSuccessUrl("/home.html", true)
            .failureUrl("/login.html?error=true")
            // .failureHandler(authenticationFailureHandler())
            .and()
            .logout()
            .logoutUrl("perform_logout")
            .deleteCookies("JSESSIONID")
            */
            // .logoutSuccessHandler(logoutSuccessHandler())
            //.httpBasic()
            ;
    }
    
}
