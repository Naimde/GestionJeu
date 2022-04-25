import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Groupe } from '../models/game.service';

@Injectable({
  providedIn: 'root'
})
export class OrgaApiService {

  baseUrl: string = 'http://localhost:8080/api/v1/groupes';
  membre:string = 'http://localhost:8080/api/v1/membres'

  constructor(private http: HttpClient) { }

  getAll(jeu:string): Observable<Groupe[]> {
    return this.http.get<Groupe[]>(this.baseUrl+"/jeu/"+jeu);
  }

  createGroupe(Groupe:any): Observable<Groupe> {
    return this.http.post<any>(this.baseUrl,Groupe)
  }

  deleteGroupe(id:string): Observable<Groupe> {
    return this.http.delete<Groupe>(this.baseUrl+'/'+id);
  }

  editGroupe(Groupe:any): Observable<Groupe>{
    return this.http.put<any>(this.baseUrl+'/'+Groupe.id_groupe,Groupe);
  }

  trouveMembre(id:string): Observable<any>{
    return this.http.get<any[]>(this.membre+"/groupe/"+id);
  }
}
