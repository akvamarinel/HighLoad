//package org.itmo.highload.userdata.security;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //auth.us
//    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        //make enable cors and csrf
////        http.cors().and().csrf().disable();
////        //make session
////        http = http
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and();
////        http = http
////                .authorizeRequests()
////                .antMatchers("/user-data/authentication", "/user-data/register").permitAll()
////                .antMatchers(HttpMethod.GET, "/category/**").authenticated()
////                .antMatchers(HttpMethod.GET, "/restaurant/**").authenticated()
////                .antMatchers(HttpMethod.GET, "/dish/**").authenticated()
////                .antMatchers(HttpMethod.GET, "/foodinrecipe/**").authenticated()
////                .antMatchers(HttpMethod.GET, "/foodstuff/**").authenticated()
////                .antMatchers(HttpMethod.GET, "/user-data/**").hasAnyRole("ROLE_USER", "ROLE_ADMIN", "ROLE_DELIVERY")
////                .antMatchers(HttpMethod.GET, "" )
////                .and();
////
////
////    }
//
//}
