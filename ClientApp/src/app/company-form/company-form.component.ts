import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { CompanyService } from '../company.service';
import { Observable } from 'rxjs';
import { CategoryService } from '../category/category.service';


@Component({
  selector: 'app-company-form',
  templateUrl: './company-form.component.html',
  styleUrls: ['./company-form.component.scss']
})
export class CompanyFormComponent implements OnInit {
  companyForm: FormGroup;
  loading = false;
  submitted =  false;
  returnUrl: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private companyService: CompanyService
  ) { }

  ngOnInit() {
    this.companyForm =  this.formBuilder.group({
      name:['', Validators.required],
      address:['', [Validators.required, Validators.maxLength(100)]],
      contact_email:['', [Validators.required, Validators.email]],
      phone_number:['', Validators.required]
    });
  }

  get fval(){return this.companyForm.controls;}

  onFormSubmit(){
    this.submitted = true;
    if(this.companyForm.invalid){
        return;
    }
    this.loading =  true;
    this.companyService.addCompany(this.companyForm.value)
    .subscribe(
        (data) => {
          alert('Company successfully added!');
        this.router.navigateByUrl('');
        this.companyForm.reset();
      }
    );
  }

}
