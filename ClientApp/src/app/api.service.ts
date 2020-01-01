import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';


import { User } from './models/user';
import { LoginUser } from './models/login-user';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private http: HttpClient) {}
  localUrl = "http://localhost:8080/login";
  options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  loginUser(user: LoginUser){
    console.log(JSON.stringify(user));
    console.log(`${environment.apiBaseUrl}/login`);
    console.log(JSON.stringify(this.options));
    return this.http.post<User>(`${environment.apiBaseUrl}/login`,JSON.stringify(user),this.options);
  }

  errorHandle(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
 }
}
