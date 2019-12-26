import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { LoginUser } from './models/login-user';

const httpLoginOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };
const localUrl = 'http://localhost:8080/login'
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private http: HttpClient) { }

  loginUser(user: LoginUser): Observable<LoginUser> {
    return this.http.post<LoginUser>(localUrl, user, httpLoginOptions);
  }
}
