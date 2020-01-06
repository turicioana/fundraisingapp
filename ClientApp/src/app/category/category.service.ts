import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }
  options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAllCategories(){
    return this.http.get<any>(`${environment.apiBaseUrl}/categories`, this.options);
  }
}
