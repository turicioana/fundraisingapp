import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

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
    returnUrl: string;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private toastr: ToastrService    
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
                this.router.navigate(['/'])
            }
            );
    }     
    
}
    /** get f() { return this.loginForm.controls;}

    onSubmit(){
        this.submitted = true;

        this.alertService.clear();

        if(this.loginForm.invalid){
            return;
        }
        this.loading = true;
        this.authenticationService.login(this.f.username.value,this.f.password.value)
        .pipe(first())
        .subscribe(
            data => {
                this.router.navigate([this.returnUrl]);
            },
            error => {
                this.alertService.error(error);
                this.loading = false;
            });
    }*/

