package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.CategoryDto;
import fundraisingapp.Base.Model.Category;

public interface ICategoryMapper {
    CategoryDto categoryToCategoryDto(Category category);
}
