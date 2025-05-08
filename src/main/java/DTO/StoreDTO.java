package DTO;

import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class StoreDTO {

    private Long id;

    @NotBlank(message = "Store name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    private Set<Long> productIds = new HashSet<>();

    public StoreDTO() {
    }

    public StoreDTO(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<Long> productIds) {
        this.productIds = productIds;
    }
}