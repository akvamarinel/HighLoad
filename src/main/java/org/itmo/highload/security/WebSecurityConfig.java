package org.itmo.highload.security;

import lombok.Setter;
import org.itmo.highload.security.jwt.JwtFilter;
import org.itmo.highload.userdata.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Setter
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Lazy
    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/delivery/register", "/api/v1/delivery/auth").permitAll()
                .antMatchers("/api/v1/customer/register", "/api/v1/customer/auth").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/api/v1/categories", "/api/v1/categories/**",
                        "/api/v1/dishes", "/api/v1/dishes/**",
                        "/api/v1/recipes", "/api/v1/recipes/**",
                        "/api/v1/restaurants", "/api/v1/restaurants/**",
                        "/api/v1/orders", "/api/v1/orders/**").hasAnyRole("DELIVERY", "ADMIN", "CUSTOMER")
                .antMatchers("/api/v1/delivery", "/api/v1/delivery/**").hasRole("DELIVERY")
                .antMatchers("/api/v1/customer", "/api/v1/customer/**").hasRole("CUSTOMER")
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}

