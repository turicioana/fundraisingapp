import { Component, OnInit } from '@angular/core';
import { AuthGuardService } from 'src/app/guards/auth-guard.service';
import * as jwt_decode from 'jwt-decode';
import * as $ from 'jquery';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  private user: string;
  private title = "FundraisingApp";
  private jQuery: any;
  constructor(
    private authGuard: AuthGuardService
  ) {
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

}
