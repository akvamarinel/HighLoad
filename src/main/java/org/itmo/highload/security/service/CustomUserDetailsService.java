package org.itmo.highload.security.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.security.jwt.CustomUserDetails;
import org.itmo.highload.userdata.model.UserData;
import org.itmo.highload.userdata.service.UserDataService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDataService userDataService;


    @Override
    public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserData user = userDataService.findByLogin(s);
        if (user == null) {
            throw new UsernameNotFoundException("User with login " + s + " not found");
        }
        return CustomUserDetails.fromUserToCustomUserDetails(user);
    }
}