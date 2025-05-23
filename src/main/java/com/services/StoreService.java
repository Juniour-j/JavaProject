package com.services;
import com.models.*;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class StoreService {
    @Autowired private StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Optional<Store> getStoreById(Long id) {
        return storeRepository.findById(id);
    }

    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
    public List<Store> searchStoresByNameOrLocation(String text) {
        return storeRepository.findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(text, text);
    }

}
