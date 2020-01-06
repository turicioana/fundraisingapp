import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FundraiserService } from '../fundraiser.service';
import { Observable } from 'rxjs';
import { CategoryService } from '../category/category.service';

import { Category } from '../models/category';

@Component({
  selector: 'app-fundraiser-form',
  templateUrl: './fundraiser-form.component.html',
  styleUrls: ['./fundraiser-form.component.scss']
})
export class FundraiserFormComponent implements OnInit {
  fundraiserForm: FormGroup;
  loading = false;
  submitted =  false;
  returnUrl: string = '/fundraisers';

  public categoriesObservable: Observable<Category[]>;


  constructor(
    private formBuilder : FormBuilder,
    private router: Router,
    private fundraiserService: FundraiserService,
    private categoryService: CategoryService
  ) {
    this.categoriesObservable = this.categoryService.getAllCategories();
   }

  ngOnInit() {
    this.fundraiserForm =  this.formBuilder.group({
      title: ['', Validators.required],
      description:['', Validators.required],
      address:['', Validators.required],
      contact_email:['', Validators.required],
      phone_number:['', Validators.required],
      category:['']
  });
  }
  get fval() {return this.fundraiserForm.controls;}

  onFormSubmit(){
    this.submitted = true;
    if(this.fundraiserForm.invalid){
        return;
    }
    this.loading =  true;
    this.fundraiserService.addFundraiser(this.fundraiserForm.value)
    .subscribe(
        (data) => {
          alert('Fundraiser successfully added!');
        this.router.navigateByUrl('/home/fundraisers');
        this.fundraiserForm.reset();
      }
    );
} 

}
