package com.example.demo.Service;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.entity.electric_user_type;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TypeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeUserService {
    @Autowired
    private TypeUserRepository typeUserRepository;

    public List<electric_user_type> getAllTypes() {
        List<electric_user_type> types = typeUserRepository.findAll();

        return types.stream().map(electric_user_type -> new electric_user_type(
                electric_user_type.getID_TYPE(),
                electric_user_type.getELEC_USER_TYPE_NAME(),
                electric_user_type.getUNIT_PRICE()
        )).collect(Collectors.toList());
    }

    public void updatePrice(int id, double newPrice) {
        electric_user_type userType = typeUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User type not found"));
        userType.setUNIT_PRICE(newPrice);
        typeUserRepository.save(userType);
    }

    public electric_user_type getUnitPriceById(Integer id) {
        electric_user_type userType = typeUserRepository.findById(id).orElse(null);
        if (userType != null) {
            return new electric_user_type(userType.getID_TYPE(),userType.getELEC_USER_TYPE_NAME(), userType.getUNIT_PRICE());
        }
        return null;
    }
}
