import { Component, OnInit } from '@angular/core';
import { FundraiserService } from '../fundraiser.service';
import { FundraiserComponent } from '../fundraiser/fundraiser.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public currentUser;
  constructor(
  ) { 
    this.currentUser = localStorage.getItem('currentUser')?JSON.parse(localStorage.getItem('currentUser')):'';
  }

  ngOnInit() {
    
  }

}
