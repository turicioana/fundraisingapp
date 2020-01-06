import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { CategoryService } from './category.service';
import { Category } from '../models/category';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  public categoriesObservable: Observable<Category[]>;

  constructor(
    private categoryService: CategoryService
  ) { 
    this.categoriesObservable = this.categoryService.getAllCategories();
  }

  ngOnInit() {
  }

}
