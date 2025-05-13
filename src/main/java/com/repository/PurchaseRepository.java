package com.repository;
import com.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByCustomer(Customer customer);
    List<Purchase> findByProduct(Product product);
    List<Purchase> findByPurchaseDate(LocalDate date);
}
