import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import {LoginUser} from '../models/login-user';
import { User } from '../models/user';
import {UserService} from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(
        private http: HttpClient,
        private userService: UserService
        ){
        this.currentUserSubject =  new BehaviorSubject<User>(JSON.parse(localStorage.getItem('token')));
        this.currentUser =  this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): LoginUser {
        return this.currentUserSubject.value;
    }

    login(email, password) {
        let loginUser = {
            email: email,
            password: password
        }
        return this.userService.login(loginUser)
        .pipe(map(user => {
            localStorage.setItem('token', JSON.stringify(user.token));
            return user;
        }));
    }
    logout(){
        localStorage.removeItem('token');
        this.currentUserSubject.next(null);
    }
}

