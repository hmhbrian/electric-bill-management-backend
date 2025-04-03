package com.example.demo.controller;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Service.CustomerService;
import com.example.demo.Service.TypeUserService;
import com.example.demo.entity.electric_user_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeusers")
public class TypeUserController {
    @Autowired
    private TypeUserService typeUserService;

    @GetMapping
    public ResponseEntity<List<electric_user_type>> getAllTypes() {
        List<electric_user_type> types = typeUserService.getAllTypes();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<electric_user_type> getUnitPriceById(@PathVariable Integer id) {
        electric_user_type userType = typeUserService.getUnitPriceById(id);
        if (userType != null) {
            return ResponseEntity.ok(userType);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePrice(@PathVariable int id, @RequestParam double newPrice) {
        typeUserService.updatePrice(id, newPrice);
        return ResponseEntity.noContent().build();
    }
}
