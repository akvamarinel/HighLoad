package org.itmo.highload.customer.controller;


import lombok.RequiredArgsConstructor;
import org.itmo.highload.customer.controller.dto.CustomerDto;
import org.itmo.highload.customer.controller.mapper.CustomerMapper;
import org.itmo.highload.customer.model.Customer;
import org.itmo.highload.customer.service.CustomerService;
import org.itmo.highload.security.dto.AuthRequest;
import org.itmo.highload.security.dto.AuthResponse;
import org.itmo.highload.security.dto.RegistrationResponse;
import org.itmo.highload.security.jwt.JwtProvider;
import org.itmo.highload.userdata.model.UserData;
import org.itmo.highload.userdata.service.UserDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final JwtProvider jwtProvider;
    private final CustomerService customerService;
    private final UserDataService userDataService;
    private final CustomerMapper customerMapper;


    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerUser(@RequestBody @Valid CustomerDto customerDto) {
        Customer customer = customerMapper.toModel(customerDto);
        UserData userData = customer.getUserData();
        if (customerService.create(customer) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new RegistrationResponse(userData.getLogin(), "Registration success"));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new RegistrationResponse(userData.getLogin(), "User with same login already exists"));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> auth(@RequestBody @Valid AuthRequest request) {
        UserData user = userDataService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse(null, "Incorrect login or password"));
        }
        String token = jwtProvider.generateToken(user.getLogin());
        return ResponseEntity.status(HttpStatus.OK).body(new AuthResponse(token, "Authorization success"));
    }
}
