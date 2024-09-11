package com.partiw.api.controller;

import com.partiw.api.domain.category.Category;
import com.partiw.api.domain.category.CategoryRequestDTO;
import com.partiw.api.domain.users.Users;
import com.partiw.api.domain.users.UsersRequestDTO;
import com.partiw.api.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> create(@RequestParam("name") String name,
                                           @RequestParam("email") String email,
                                           @RequestParam("password") String password,
                                           @RequestParam("companyId") UUID companyId) {
        UsersRequestDTO usersRequestDTO = new UsersRequestDTO(name, email, companyId, password);
        Users newUsers = this.usersService.createUser(usersRequestDTO);
        return ResponseEntity.ok(newUsers);
    }

    @GetMapping
    public ResponseEntity<Users> get(@RequestParam("categoryId") UUID userId) {
        Users user = this.usersService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Map<String, Object> payload) {
        String email = (String) payload.get("email");
        String password = (String) payload.get("password");
        Users user = this.usersService.login(email, password);
        return ResponseEntity.ok(user);
    }
}
