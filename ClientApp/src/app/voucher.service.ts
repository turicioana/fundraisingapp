import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Voucher } from './models/voucher';

@Injectable({
  providedIn: 'root'
})
export class VoucherService {

  constructor(private http: HttpClient) { }
  options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  getAllVouchers(){
    return this.http.get<any>(`${environment.apiBaseUrl}/vouchers`,this.options); 
  }

  getVoucher(id: string){
    return this.http.get<Voucher>(`${environment.apiBaseUrl}/vouchers/${id}`,this.options);
  }
}
