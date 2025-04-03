package com.example.demo.controller;

import com.example.demo.Service.AccountElecService;
import com.example.demo.entity.AccountElec;
import com.example.demo.entity.Customer;
import com.example.demo.entity.electric_user_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AccountElecController {

    @Autowired
    private AccountElecService accountElecService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        AccountElec user = accountElecService.findByUsernameAndPassword(username, password);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<List<AccountElec>> getAllAccountElec() {
        List<AccountElec> accountElecs = accountElecService.getAllAccount();
        return new ResponseEntity<>(accountElecs, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AccountElec> register(@RequestBody AccountElec request) {
        try {
            System.out.println(request.getUSERNAME()+"-"+request.getPASS());
            AccountElec createdAccount = accountElecService.register(request.getUSERNAME(), request.getPASS());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/get-id")
    public Integer getIdByUsername(@RequestParam String username) {
        Integer id = accountElecService.getIdByUsername(username);
        if (id == null) {
            throw new RuntimeException("Username not found: " + username);
        }
        return id;
    }

    @GetMapping("/recoverPassword")
    public ResponseEntity<?> recoverPassword(@RequestParam String username) {
        try {
            String password = accountElecService.getPasswordByUsername(username);
            if (password != null) {
                return ResponseEntity.ok(password);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
