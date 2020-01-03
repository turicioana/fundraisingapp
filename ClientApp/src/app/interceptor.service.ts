import { Injectable } from '@angular/core';
import {HttpInterceptor, HttpRequest, HttpHandler, HttpEvent} from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(req:HttpRequest<any>, next:HttpHandler):Observable<HttpEvent<any>>{
    if (!(req.url.indexOf("/login")>-1) && !(req.url.indexOf("/register")>-1)){
      req = req.clone({
        headers: req.headers.set(
          "Authorization",
          "Bearer " + localStorage.getItem("token").replace('"','').replace('"','')
        ),
        url:req.url
      });
    }
    return next.handle(req);
  }
}
