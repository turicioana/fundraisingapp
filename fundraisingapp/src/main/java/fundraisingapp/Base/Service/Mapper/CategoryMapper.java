package fundraisingapp.Base.Service.Mapper;


import fundraisingapp.Base.Dto.CategoryDto;
import fundraisingapp.Base.Model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper implements ICategoryMapper {
    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
