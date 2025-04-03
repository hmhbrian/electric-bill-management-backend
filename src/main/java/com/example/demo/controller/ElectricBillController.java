package com.example.demo.controller;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Service.ElectricBillService;
import com.example.demo.entity.electric_bill;
import com.example.demo.entity.electric_user_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/electric_bills")
public class ElectricBillController {

    @Autowired
    private ElectricBillService electricBillService;

    @GetMapping
    public ResponseEntity<List<electric_bill>> getAllBills() {
        List<electric_bill> bills = electricBillService.getAllBill();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @GetMapping("/overdue/{customerId}")
    public ResponseEntity<List<electric_bill>>  getDueBills(@PathVariable long customerId) {
        List<electric_bill> duebills = electricBillService.getOverdueBills(customerId);
        if (duebills.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(duebills);
    }

    @PutMapping("/update-late-fee")
    public ResponseEntity<String> updateLateFeeAndStatus() {
        int updatedRows = electricBillService.updateLateFeeAndStatus();
        return ResponseEntity.ok("Updated " + updatedRows + " bills with late fees and status.");
    }

    @GetMapping("/overdueDetail/{id}")
    public ResponseEntity<Object> getDueBillDetails(@PathVariable int id) {
        try {
            electric_bill bill = electricBillService.getDueBillDetailsById(id);
            return ResponseEntity.ok(bill);
        } catch (RuntimeException e) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

