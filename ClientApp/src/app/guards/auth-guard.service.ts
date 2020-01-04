import { Injectable, ComponentFactoryResolver } from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import * as jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  public currentUser = JSON.parse(localStorage.getItem('token'));
  constructor(
    private router: Router,
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.currentUser){
      var decode = jwt_decode(this.currentUser);
      console.log(decode['roles'][0]['authority']);
      if(route.data.roles && route.data.roles.indexOf(decode['roles'][0]['authority']) == -1){
        this.router.navigate(['/auth']);
        return false;
      }
      return true;
    }
    this.router.navigate(['/login'], {queryParams: {returnUrl:state.url}});
    return false;
  }
}
