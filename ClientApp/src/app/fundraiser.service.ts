import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Fundraiser } from './models/fundraiser';
import { Observable } from 'rxjs';
import { stringToKeyValue } from '@angular/flex-layout/extended/typings/style/style-transforms';
import { Voucher } from './models/voucher';
import { ActiveAccount } from './models/activeAccount';
import { Donation } from './models/donation';


@Injectable({
  providedIn: 'root'
})
export class FundraiserService {

  constructor(private http: HttpClient) { }
  options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };

  getAllFundraisers(){
    return this.http.get<any>(`${environment.apiBaseUrl}/fundraisers`,this.options); 
  }

  addFundraiser(fundraiser: Fundraiser){
    return this.http.post<Fundraiser>(`${environment.apiBaseUrl}/fundraisers`,JSON.stringify(fundraiser),this.options);
  }

  getFundraiser(id: string){
    return this.http.get<Fundraiser>(`${environment.apiBaseUrl}/fundraisers/${id}`,this.options);
  }

  addVoucherForFundraiser(id:string, voucher: Voucher){
    return this.http.post<Voucher>(`${environment.apiBaseUrl}/fundraisers/${id}/vouchers`,JSON.stringify(voucher),this.options);
  }

  activateAccount(id:string, active: ActiveAccount){
    return this.http.patch<ActiveAccount>(`${environment.apiBaseUrl}/fundraisers/${id}`, JSON.stringify(active), this.options);
  }

  addDonatioForFundraiser(id:string,donation:Donation){
    return this.http.post<Donation>(`${environment.apiBaseUrl}/fundraisers/${id}/donations`, JSON.stringify(donation), this.options);
  }

}
