import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Role, User } from '../models/accounts.service';

@Injectable({
  providedIn: 'root'
})
export class AdminApiService {

  baseUrl: string = 'http://localhost:8080/api/v1/users';

  constructor(private http: HttpClient) { }

  getAll(): Observable<User[]> {
    return this.http.get<User[]>(this.baseUrl);
  }

  createUser(user:any): Observable<User> {
    return this.http.post<any>(this.baseUrl,user)
  }

  deleteUser(id:string): Observable<User> {
    return this.http.delete<User>(this.baseUrl+'/'+id);
  }

  deleteRole(id:string,idrole:string): Observable<Role>{
    return this.http.delete<Role>(this.baseUrl+"/"+id+"/roles/"+idrole);
  }

  addRole(id:string,roleId:any): Observable<Role>{
    return this.http.post<Role>(this.baseUrl+"/"+id+"/roles",{"roleId":roleId});
  }

  listRoles(): Observable<Role[]>{
    return this.http.get<Role[]>("http://localhost:8080/api/v1/roles");
  }

  createGame(game:any):Observable<Role>{
    return this.http.post<any>("http://localhost:8080/api/v1/roles",{"name":game});
  }

  editUser(user:any): Observable<User>{
    return this.http.put<any>(this.baseUrl+'/'+user.username,user);
  }
}
