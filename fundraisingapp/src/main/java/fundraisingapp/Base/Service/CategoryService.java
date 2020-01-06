package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.CategoryDto;
import fundraisingapp.Base.Model.Category;
import fundraisingapp.Base.Repositories.ICategoryRepository;
import fundraisingapp.Base.Service.Mapper.ICategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private ICategoryMapper categoryMapper;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    public CategoryService(ICategoryRepository categoryRepository, ICategoryMapper categoryMapper,
                           AuthenticationFacade authenticationFacade) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoriesDto = new ArrayList<>();
        for (Category category : categories) {
            categoriesDto.add(categoryMapper.categoryToCategoryDto(category));
        }
        return categoriesDto;
    }
}
