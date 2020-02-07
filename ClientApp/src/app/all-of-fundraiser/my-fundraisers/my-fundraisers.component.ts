import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Fundraiser } from 'src/app/models/fundraiser';
import { FundraiserService } from 'src/app/fundraiser.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-fundraisers',
  templateUrl: './my-fundraisers.component.html',
  styleUrls: ['./my-fundraisers.component.scss']
})
export class MyFundraisersComponent implements OnInit {

  public fundraisersObservable: Observable<Fundraiser[]>;

  constructor(
    private fundraiserService: FundraiserService,
    private router: Router
  ) {
    this.fundraisersObservable = this.fundraiserService.getAllFundraiserByUser();
   }

  ngOnInit() {
  }

}
