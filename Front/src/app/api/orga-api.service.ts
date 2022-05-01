import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Groupe, Personnage, Membre } from '../models/game.service';

@Injectable({
  providedIn: 'root'
})
export class OrgaApiService {

  baseUrl: string = 'http://localhost:8080/api/v1/groupes';
  membre:string = 'http://localhost:8080/api/v1/membres';
  personnage:string = 'http://localhost:8080/api/v1/personnages';

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

  editGroupe(Groupe:Groupe): Observable<Groupe>{
    return this.http.put<any>(this.baseUrl+'/'+Groupe.id_groupe,Groupe);
  }

  trouveMembre(id:string): Observable<any>{
    return this.http.get<any[]>(this.membre+"/groupe/"+id);
  }

  createMembre(membre:any): Observable<Groupe> {
    return this.http.post<any>(this.membre,membre)
  }

  editMembre(membre:Membre): Observable<any>{
    return this.http.put<any[]>(this.membre,membre);
  }

  deleteMembre(membre:Membre): Observable<Membre> {
    return this.http.delete<Membre>(this.membre+'/'+membre.idGroupe+"/"+membre.idPersonnage);
  }

  getAllPersonnage(jeu:string): Observable<Personnage[]>{
    return this.http.get<Personnage[]>(this.personnage+"/jeu/"+jeu);
  }

  getPersonnage(id:string): Observable<Personnage>{
    return this.http.get<Personnage>(this.personnage+"/"+id);;
  }
}
