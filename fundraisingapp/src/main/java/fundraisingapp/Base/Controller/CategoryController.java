package fundraisingapp.Base.Controller;

import fundraisingapp.Base.Dto.CategoryDto;
import fundraisingapp.Base.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PreAuthorize("hasAnyAuthority('FUNDRAISER', 'USER', 'COMPANY','ADMIN')")
    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
