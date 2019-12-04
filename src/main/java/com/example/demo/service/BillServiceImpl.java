package com.example.demo.service;

import com.example.demo.models.Bill;
import com.example.demo.models.User;
import com.example.demo.repos.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill findBillById(Integer id) {
        return billRepository.findBillById(id);
    }

    @Override
    public List<User> findBillsByUser(User user) {
        return billRepository.findBillsByUser(user);
    }

    @Override
    public List<User> findBillsByUsername(String username) {
        return null;
    }

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public void deleteBillById(Integer id) {
        billRepository.deleteBillById(id);
    }

    @Override
    public List<Bill> allBills() {
        return billRepository.findAll();
    }
}
