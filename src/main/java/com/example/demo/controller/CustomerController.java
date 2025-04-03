package com.example.demo.controller;

import com.example.demo.DTO.AvatarDTO;
import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Service.CustomerService;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerDetails(@PathVariable Long id) {
        try {
            CustomerDTO customerDTO = customerService.getCustomerDetailsById(id);
            return new ResponseEntity<>(customerDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ids")
    public ResponseEntity<List<Long>> getAllCustomerIds() {
        List<Long> customerIds = customerService.getAllCustomerIds();
        return ResponseEntity.ok(customerIds);
    }

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer createdCustomer = customerService.addCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }}

    // Update an existing customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable long id,
            @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }
    //update avatar
    @PutMapping("/avatar/{id}")
    public ResponseEntity<?> updateAvatar(
            @PathVariable long id,
            @RequestBody Map<String, String> requestBody) {
        // Lấy đường dẫn avatar từ request body
        String pathAvatar = requestBody.get("pathAvatar");
        if (pathAvatar == null || pathAvatar.isEmpty()) {
            return ResponseEntity.badRequest().body("Avatar path cannot be empty");
        }

        // Cập nhật avatar của khách hàng
        try {
            Customer updatedCustomer = customerService.updateAvatar(id, pathAvatar);
            return ResponseEntity.ok(updatedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating avatar: " + e.getMessage());
        }
    }

    @GetMapping("/avatar/{id}")
    public ResponseEntity<Object> getAvatarByCustomerId(@PathVariable long id) {
        String avatar = customerService.getAvatarById(id);
        if (avatar != null) {
            return ResponseEntity.ok(new AvatarDTO(avatar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    //Search customers
    @GetMapping("/search")
    public ResponseEntity<List<CustomerDTO>> searchCustomers(@RequestParam String keyword) {
        List<CustomerDTO> customers = customerService.searchCustomers(keyword);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/by-user")
    public ResponseEntity<Object> getCustomerByUserId(@RequestParam int idUser) {
        Customer customer = customerService.getCustomerByUserId(idUser);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Customer not found"));
        }
    }
}
