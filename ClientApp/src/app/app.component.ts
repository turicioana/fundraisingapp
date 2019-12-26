import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { LoginUser } from './models/login-user';
import {ApiService} from './api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'FundraisingApp';
  currentUser: LoginUser;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private api: ApiService
  ){
    this.authenticationService.currentUser.subscribe( x=> this.currentUser = x);
  }

  logout(){
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }
}
