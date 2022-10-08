import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router} from '@angular/router';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  
  constructor(
    private router: Router
  ) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(this.TokenFini()){
      this.router.navigate(['/login']);
      return next.handle(req);
    }
    const token = localStorage.getItem('token');    
    const req1 = req.clone({
      headers: req.headers.set('Authorization', `Bearer ${token}`),
    });

    return next.handle(req1);
  }

  TokenFini():boolean{
    if(Date.parse(localStorage.getItem('expiration')!)<Date.now()||localStorage.getItem('expiration')==null){
      localStorage.removeItem('token');
      localStorage.removeItem('expiration');
      return true;
    } 
    return false;
  }

}