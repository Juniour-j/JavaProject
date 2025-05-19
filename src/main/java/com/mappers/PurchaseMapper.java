package com.mappers;
import com.dto.*;
import com.models.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PurchaseMapper {

    public PurchaseDTO toDTO(Purchase purchase) {
        if (purchase == null) return null;
        PurchaseDTO dto = new PurchaseDTO();
        dto.setId(purchase.getId());
        dto.setCustomerId(purchase.getCustomer().getId());
        dto.setCustomerName(purchase.getCustomer().getName());
        dto.setProductId(purchase.getProduct().getId());
        dto.setProductName(purchase.getProduct().getName());
        dto.setPurchaseDate(purchase.getPurchaseDate());
        return dto;
    }

    public Purchase toEntity(PurchaseDTO dto) {
        if (dto == null) return null;
        Purchase purchase = new Purchase();
        purchase.setId(dto.getId());
        purchase.setPurchaseDate(dto.getPurchaseDate());
        return purchase;
    }

    public List<PurchaseDTO> toDTOList(List<Purchase> purchases) {
        return purchases.stream().map(this::toDTO).collect(Collectors.toList());
    }
}