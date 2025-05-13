package com.mappers;
import com.DTO.*;
import com.models.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        if (customer == null) return null;
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        if (customer.getPurchases() != null) {
            dto.setPurchaseIds(customer.getPurchases().stream().map(Purchase::getId).collect(Collectors.toSet()));
        }
        return dto;
    }

    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) return null;
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        return customer;
    }

    public List<CustomerDTO> toDTOList(List<Customer> customers) {
        return customers.stream().map(this::toDTO).collect(Collectors.toList());
    }
}

