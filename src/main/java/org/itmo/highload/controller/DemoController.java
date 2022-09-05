package org.itmo.highload.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DemoController {

    private final List<Map<String, String>> users = new ArrayList<>();

    {
        for (long i = 0; i < 10; ++i) {
            Map<String, String> u = new HashMap<>();
            u.put("name", "Masha");
            u.put("age", "2");
            u.put("surname", "Karaseva");
            users.add(u);
            users.add(u);
            users.add(u);
        }
    }

    @GetMapping("/users")
    public List<Map<String, String>> getAll() {
        return users;
    }
}
