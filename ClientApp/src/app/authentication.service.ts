import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import {LoginUser} from '../app/models/login-user';
import { User } from './models/user';
import {ApiService} from './api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(
        private http: HttpClient,
        private api: ApiService){
        this.currentUserSubject =  new BehaviorSubject<User>(JSON.parse(localStorage.getItem('token')));
        this.currentUser =  this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): LoginUser {
        return this.currentUserSubject.value;
    }

    login(email, password) {
        let user = {
            email: email,
            password: password,
            token: ''
        };
        return this.api.loginUser(user)
        .pipe(map(user => {
            localStorage.setItem('token', JSON.stringify(user.token));
            this.currentUserSubject.next(user);
            return user;
        }));
    }
    logout(){
        localStorage.removeItem('token');
        this.currentUserSubject.next(null);
    }
}

