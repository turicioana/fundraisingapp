import { Component, OnInit } from '@angular/core';
import { FundraiserService } from '../../fundraiser.service';
import { Fundraiser } from '../../models/fundraiser';
import { Observable } from 'rxjs';
import * as jwt_decode from 'jwt-decode';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fundraiser',
  templateUrl: './fundraiser.component.html',
  styleUrls: ['./fundraiser.component.scss']
})
export class FundraiserComponent implements OnInit {

  public currentUser;
  public fundraisersObservable: Observable<Fundraiser[]>;

  constructor(
    private fundraiserService: FundraiserService,
    private router: Router
  ) {
    this.fundraisersObservable = this.fundraiserService.getAllFundraisers();
   }

  ngOnInit() {
  }

  hasRole(role: string){
    this.currentUser = JSON.parse(localStorage.getItem('token'));
    if(this.currentUser){
      var decode = jwt_decode(this.currentUser);
      if(role.indexOf(decode['roles'][0]['authority']) == -1){
        return false
      }
      return true;
    }
    return false;
  }

  activateAccount(id:string){
    var active = {
      active : true as boolean
    }
    this.fundraiserService.activateAccount(id,active).subscribe(
      (data) => {
      alert('Fundraiser successfully activated!');
      this.router.navigateByUrl('/fundraisers');
      this.fundraisersObservable = this.fundraiserService.getAllFundraisers();
      }
    )
  }
}
