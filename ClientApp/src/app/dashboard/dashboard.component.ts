import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category/category.service';
import { Observable } from 'rxjs';
import * as jwt_decode from 'jwt-decode';

import { Category } from '../models/category';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  public categoriesObservable: Observable<Category[]>;
  public currentUser;

  constructor(
    private categoryService: CategoryService
  ) { 
    this.categoriesObservable = this.categoryService.getAllCategories();
  }

  ngOnInit() {
  }
  hasRole(role: string){
    this.currentUser = JSON.parse(localStorage.getItem('token'));
    if(this.currentUser){
      var decode = jwt_decode(this.currentUser);
      if(role.indexOf(decode['roles'][0]['authority']) == -1){
        return false
      }
      return true;
    }
    return false;
  }


}
