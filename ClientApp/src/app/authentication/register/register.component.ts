import { Component, OnInit , ViewChild} from '@angular/core';
import { Router} from '@angular/router';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';

import {UserService} from '../user.service'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  // @ViewChild('registerForm', {static: false}) 
  registerForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string = '';
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService,
  ) { }

  ngOnInit() {
    this.registerForm =  this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      name:['', Validators.required],
      password:['', [Validators.required, Validators.minLength(6)]],
      matchingPassword:['',[Validators.required, Validators.minLength(6)]]
    });
  }

  get fval() {return this.registerForm.controls;}

  onFormSubmit(){
    this.submitted =  true;
    if(this.registerForm.invalid){
      return;
    }
    this.loading =  true;
    this.userService.register(this.registerForm.value).subscribe(
      (data) =>{
        alert('User inregistrat cu succes! Acum te poti autentifica!');
        this.router.navigate([this.returnUrl]);
        this.registerForm.reset();
      }
    )
  }
}
