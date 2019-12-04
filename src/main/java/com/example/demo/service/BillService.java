package com.example.demo.service;

import com.example.demo.models.Bill;
import com.example.demo.models.User;

import java.util.List;

public interface BillService {
    Bill findBillById(Integer id);
    List<User> findBillsByUser(User user);
    List<User> findBillsByUsername(String username);
    void save(Bill bill);
    void deleteBillById(Integer id);
    List<Bill> allBills();
}