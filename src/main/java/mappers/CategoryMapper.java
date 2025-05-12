package mappers;
import DTO.*;
import models.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class CategoryMapper {

    public CategoryDTO toDTO(Category category) {
        if (category == null) return null;
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        if (category.getProducts() != null) {
            dto.setProductIds(category.getProducts().stream().map(Product::getId).collect(Collectors.toSet()));
        }
        return dto;
    }

    public Category toEntity(CategoryDTO dto) {
        if (dto == null) return null;
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }

    public List<CategoryDTO> toDTOList(List<Category> categories) {
        return categories.stream().map(this::toDTO).collect(Collectors.toList());
    }
}