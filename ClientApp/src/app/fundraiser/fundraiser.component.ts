import { Component, OnInit } from '@angular/core';
import { FundraiserService } from '../fundraiser.service';
import { Fundraiser } from '../models/fundraiser';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-fundraiser',
  templateUrl: './fundraiser.component.html',
  styleUrls: ['./fundraiser.component.scss']
})
export class FundraiserComponent implements OnInit {

  private fundraisers: Fundraiser[] = [];
  public fundraisersObservable: Observable<Fundraiser[]>;

  constructor(
    private fundraiserService: FundraiserService
  ) {
    this.fundraisersObservable = this.fundraiserService.getAllFundraisers();
   }

  ngOnInit() {
  }

}
