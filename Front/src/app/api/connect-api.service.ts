import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConnectApiService {

  baseUrl: String = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getToken(login:String,password:String): Observable<any> {
    return this.http.post<any>(this.baseUrl+'authorize',{'username':login,'password':password});
  }

  getReturn(): Observable<any> {
    return this.http.get<any>(this.baseUrl+'me');
  }
}