package com.example.demo.repos;

import com.example.demo.models.Bill;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    Bill findBillById(Integer id);
    void deleteBillById(Integer id);
    List<User> findBillsByUser(User user);
}


