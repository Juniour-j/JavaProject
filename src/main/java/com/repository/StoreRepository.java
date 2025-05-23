package com.repository;
import com.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByLocation(String location);
    List<Store> findByNameContainingIgnoreCase(String name);

    List<Store> findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(String name, String location);
}
