import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category/category.service';
import { Observable } from 'rxjs';

import { Category } from '../models/category';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  public categoriesObservable: Observable<Category[]>;

  constructor(
    private categoryService: CategoryService
  ) { 
    this.categoriesObservable = this.categoryService.getAllCategories();
  }

  ngOnInit() {
  }

}
