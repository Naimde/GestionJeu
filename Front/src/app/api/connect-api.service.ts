import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export function CreateHeader() {
  var headers_object = new HttpHeaders({
    'Content-Type': 'application/json',
     'Authorization': "Bearer "+ localStorage.getItem("token")
  });
  return {headers:headers_object};
}

@Injectable({
  providedIn: 'root'
})
export class ConnectApiService {

  temporaire:any=undefined;
  baseUrl: String = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getToken(login:String,password:String): Observable<any> {
    this.temporaire=this.http.post<any>(this.baseUrl+'authorize',{'username':login,'password':password});
    return this.temporaire;
  }

  getReturn(): Observable<any> {
    return this.http.get<any>(this.baseUrl+'me');
  }
}