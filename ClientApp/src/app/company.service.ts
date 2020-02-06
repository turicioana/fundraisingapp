import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Company } from './models/company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) { }
  options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  addCompany(company: Company){
    return this.http.post<Company>(`${environment.apiBaseUrl}/companies`,JSON.stringify(company),this.options);
  }
}
