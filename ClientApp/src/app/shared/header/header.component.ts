import { Component, OnInit } from '@angular/core';
import { AuthGuardService } from 'src/app/guards/auth-guard.service';
import * as jwt_decode from 'jwt-decode';
import * as $ from 'jquery';
import { BehaviorSubject } from 'rxjs';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  private user: string;
  private title = "BePresent";
  private jQuery: any;
  private currentUserSubject: BehaviorSubject<User>;
  constructor(
    private authGuard: AuthGuardService,
    private router: Router
  ) {
    this.currentUserSubject =  new BehaviorSubject<User>(JSON.parse(localStorage.getItem('token')));
    this.user = jwt_decode(this.authGuard.currentUser)['username'];
   }

  ngOnInit() {
    (function smth(){
      $(document).ready(function(){
        $('#nav-icon1,#nav-icon2,#nav-icon3,#nav-icon4').click(function(){
          $(this).toggleClass('open');
        });
      });
    })();
  }

  logout(){
    localStorage.removeItem('token');
    this.router.navigateByUrl('/auth');
    this.currentUserSubject.next(null);
}

}
