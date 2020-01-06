import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Fundraiser } from './models/fundraiser';

@Injectable({
  providedIn: 'root'
})
export class FundraiserService {

  constructor(private http: HttpClient) { }
  options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAllFundraisers(){
    return this.http.get<any>(`${environment.apiBaseUrl}/fundraisers`,this.options); 
  }

  addFundraiser(fundraiser: Fundraiser){
    return this.http.post<Fundraiser>(`${environment.apiBaseUrl}/fundraisers`,JSON.stringify(fundraiser),this.options);
  }
}
