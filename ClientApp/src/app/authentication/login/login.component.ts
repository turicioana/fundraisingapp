import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';

import { AuthenticationService } from '../authentication.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
    loginForm : FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string = '';

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private authenticationService: AuthenticationService,
    ){
    }

    ngOnInit() {
        this.loginForm =  this.formBuilder.group({
            username: ['', Validators.required],
            password:['', Validators.required]
        });
    }

    get fval() {return this.loginForm.controls;}

    onFormSubmit(){
        this.submitted = true;
        if(this.loginForm.invalid){
            return;
        }
        this.loading =  true;
        this.authenticationService.login(this.fval.username.value, this.fval.password.value)
        .subscribe(
            data => {
                this.router.navigate([this.returnUrl])
            }
        );
    }     
    
}