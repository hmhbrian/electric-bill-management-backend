package com.example.demo.Service;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.electric_user_type;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TypeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TypeUserRepository electricUserTypeRepository;

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        Map<Integer, electric_user_type> userTypeMap = electricUserTypeRepository.findAll().stream()
                .collect(Collectors.toMap(
                        electricUserType -> electricUserType.getID_TYPE(),
                        electricUserType -> new electric_user_type(
                                electricUserType.getELEC_USER_TYPE_NAME(),
                                electricUserType.getUNIT_PRICE()
                        )
                ));
        // Chuyển đổi Customer sang CustomerDTO
        return customers.stream().map(customer -> {
            electric_user_type userType = userTypeMap.get(customer.getELEC_USER_TYPE_ID());
            return new CustomerDTO(
                    customer.getID(),
                    customer.getNAME(),
                    customer.getYYYYMM(),
                    customer.getADDRESS(),
                    customer.getUSED_NUM_ELECTRIC(),
                    userType.getELEC_USER_TYPE_NAME(),
                    userType.getUNIT_PRICE()
            );
        }).collect(Collectors.toList());
    }

    public CustomerDTO getCustomerDetailsById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
        Map<Integer, electric_user_type> userTypeMap = electricUserTypeRepository.findAll().stream()
                .collect(Collectors.toMap(
                        electricUserType -> electricUserType.getID_TYPE(),
                        electricUserType -> electricUserType
                ));
        electric_user_type userType = userTypeMap.get(customer.getELEC_USER_TYPE_ID());
        if (userType == null) {
            throw new RuntimeException("Electric user type not found for ID: " + customer.getELEC_USER_TYPE_ID());
        }
        return new CustomerDTO(
                customer.getID(),
                customer.getNAME(),
                customer.getYYYYMM(),
                customer.getADDRESS(),
                customer.getUSED_NUM_ELECTRIC(),
                userType.getELEC_USER_TYPE_NAME(),
                userType.getUNIT_PRICE()
        );
    }

    public List<Long> getAllCustomerIds() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(Customer::getID)
                .collect(Collectors.toList());
    }

    // Insert customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update customer
    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        // Tìm Customer hiện tại trong database
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Cập nhật các trường cơ bản
        existingCustomer.setNAME(updatedCustomer.getNAME());
        existingCustomer.setYYYYMM(updatedCustomer.getYYYYMM());
        existingCustomer.setADDRESS(updatedCustomer.getADDRESS());
        existingCustomer.setUSED_NUM_ELECTRIC(updatedCustomer.getUSED_NUM_ELECTRIC());
        existingCustomer.setELEC_USER_TYPE_ID(updatedCustomer.getELEC_USER_TYPE_ID());
        return customerRepository.save(existingCustomer);
    }

    public Customer updateAvatar(long id, String pathAvatar) {
        // Tìm khách hàng theo ID
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new RuntimeException("Customer not found with id: " + id);
        }

        // Cập nhật avatar
        Customer customer = customerOptional.get();
        customer.setAVATAR(pathAvatar);
        return customerRepository.save(customer);
    }

    public String getAvatarById(long id) {
        // Tìm kiếm khách hàng theo ID
        return customerRepository.findById(id)
                .map(Customer::getAVATAR) // Lấy thuộc tính avatar
                .orElse(null); // Trả về null nếu không tìm thấy
    }

    // Delete customer
    public void deleteCustomer(long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
    }

    public List<CustomerDTO> searchCustomers(String keyword) {
        List<Customer> customers = customerRepository.searchCustomersByName(keyword);
        Map<Integer, electric_user_type> userTypeMap = electricUserTypeRepository.findAll().stream()
                .collect(Collectors.toMap(
                        electricUserType -> electricUserType.getID_TYPE(),
                        electricUserType -> new electric_user_type(
                                electricUserType.getELEC_USER_TYPE_NAME(),
                                electricUserType.getUNIT_PRICE()
                        )
                ));
        // Chuyển đổi Customer sang CustomerDTO
        return customers.stream().map(customer -> {
            electric_user_type userType = userTypeMap.get(customer.getELEC_USER_TYPE_ID());
            return new CustomerDTO(
                    customer.getID(),
                    customer.getNAME(),
                    customer.getYYYYMM(),
                    customer.getADDRESS(),
                    customer.getUSED_NUM_ELECTRIC(),
                    userType.getELEC_USER_TYPE_NAME(),
                    userType.getUNIT_PRICE()
            );
        }).collect(Collectors.toList());
    }

    public Customer getCustomerByUserId(int idUser) {
        return customerRepository.findByIdUser(idUser).orElse(null);
    }

}
