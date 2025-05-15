package com.mappers;
import com.dto.*;
import com.models.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreMapper {

    public StoreDTO toDTO(Store store) {
        if (store == null) return null;
        StoreDTO dto = new StoreDTO();
        dto.setId(store.getId());
        dto.setName(store.getName());
        dto.setLocation(store.getLocation());
        if (store.getProducts() != null) {
            dto.setProductIds(store.getProducts().stream().map(Product::getId).collect(Collectors.toSet()));
        }
        return dto;
    }

    public Store toEntity(StoreDTO dto) {
        if (dto == null) return null;
        Store store = new Store();
        store.setId(dto.getId());
        store.setName(dto.getName());
        store.setLocation(dto.getLocation());
        return store;
    }

    public List<StoreDTO> toDTOList(List<Store> stores) {
        return stores.stream().map(this::toDTO).collect(Collectors.toList());
    }
}