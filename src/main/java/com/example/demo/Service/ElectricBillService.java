package com.example.demo.Service;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.electric_bill;
import com.example.demo.entity.electric_user_type;
import com.example.demo.repository.ElectricBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ElectricBillService {

    @Autowired
    private ElectricBillRepository electricBillRepository;

    public List<electric_bill> getAllBill() {
        List<electric_bill> bills = electricBillRepository.findAll();

        return bills.stream().map(electric_bill -> new electric_bill(
                electric_bill.getID(),
                electric_bill.getBILL_DATE(),
                electric_bill.getDUE_DATE(),
                electric_bill.getPAID_DATE(),
                electric_bill.getTOTAL_ELEC(),
                electric_bill.getTOTAL_AMOUNT(),
                electric_bill.getIS_PAID(),
                electric_bill.getLATE_FEE(),
                electric_bill.getCUSTOMER_ID()
        )).collect(Collectors.toList());
    }

    public List<electric_bill> getOverdueBills(long customerId) {
        return electricBillRepository.findOverdueBillsByCustomerId(customerId);
    }

    public int updateLateFeeAndStatus() {
        return electricBillRepository.updateLateFeeAndStatus();
    }

    public electric_bill getDueBillDetailsById(int id) {
        electric_bill electric_bill = electricBillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dua bill not found with ID: " + id));

        return electric_bill;
    }
}

