import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

import { RegisterUser } from '../models/register-user';
import { User } from '../models/user';
import { LoginUser } from '../models/login-user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  login(user: LoginUser){
    return this.http.post<User>(`${environment.apiBaseUrl}/login`,JSON.stringify(user),this.options);
  }

  register(user: RegisterUser) {
    console.log(JSON.stringify(user));
    console.log(`${environment.apiBaseUrl}/register`);
    console.log(JSON.stringify(this.options));
    return this.http.post<RegisterUser>(`${environment.apiBaseUrl}/register`,JSON.stringify(user),this.options);
    }
}
