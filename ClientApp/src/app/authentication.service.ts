import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import {LoginUser} from '../app/models/login-user';
import {ApiService} from './api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<LoginUser>;
    public currentUser: Observable<LoginUser>;

    constructor(
        private http: HttpClient,
        private api: ApiService){
        this.currentUserSubject =  new BehaviorSubject<LoginUser>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser =  this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): LoginUser {
        return this.currentUserSubject.value;
    }

    login(username, password) {
        var user: LoginUser = {
            username: username,
            password: password
        }
        return this.api.loginUser(user)
        .pipe(map(user => {
            localStorage.setItem('currentUser', JSON.stringify(user));
            this.currentUserSubject.next(user);
            return user;
        }));
    }
    logout(){
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}

