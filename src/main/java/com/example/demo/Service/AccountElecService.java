package com.example.demo.Service;

import com.example.demo.entity.AccountElec;
import com.example.demo.entity.Customer;
import com.example.demo.entity.electric_user_type;
import com.example.demo.repository.AccountElecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountElecService {
    @Autowired
    private AccountElecRepository accountElecRepository;

    public AccountElec findByUsernameAndPassword(String username, String password) {
        return accountElecRepository.findByUSERNAMEAndPASS(username, password)
                .orElse(null);
    }


    public List<AccountElec> getAllAccount() {
        List<AccountElec> types = accountElecRepository.findAll();

        return types.stream().map(account -> new AccountElec(
                account.getID_USER(),
                account.getUSERNAME(),
                account.getPASS(),
                account.getROLE_ACC()
        )).collect(Collectors.toList());
    }

    public AccountElec register(String username, String password) {
        Optional<AccountElec> existingUser = accountElecRepository.findByUSERNAME(username);
        if (existingUser.isPresent()) {
            System.out.println("Username đã tồn tại!");
            return null;
        }

        AccountElec account = new AccountElec();
        account.setUSERNAME(username);
        account.setPASS(password);
        return accountElecRepository.save(account);
    }

    public Integer getIdByUsername(String username) {
        return accountElecRepository.findIdByUSERNAME(username);
    }
    public String getPasswordByUsername(String username) {
        Optional<AccountElec> accountOptional = accountElecRepository.findByUSERNAME(username);
        AccountElec account = accountOptional.orElse(null); // Chuyển Optional thành AccountElec
        if (account != null) {
            return account.getPASS(); // Lấy trực tiếp password
        }
        return null;
    }
}
