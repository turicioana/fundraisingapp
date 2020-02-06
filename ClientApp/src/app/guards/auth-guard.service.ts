import { Injectable, ComponentFactoryResolver } from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import * as jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  public currentUser;
  constructor(
    private router: Router,
  ) {
    this.currentUser = JSON.parse(localStorage.getItem('token'));
   }

  canActivate(route: ActivatedRouteSnapshot){
    this.currentUser = JSON.parse(localStorage.getItem('token'));
    if(this.currentUser){
      var decode = jwt_decode(this.currentUser);
      if(route.data.roles && route.data.roles.indexOf(decode['roles'][0]['authority']) == -1){
        this.router.navigate(['/auth']);
        return false;
      }
      return true;
    }
    return this.router.parseUrl('/auth');
  }
}
