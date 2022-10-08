import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Groupe, Personnage, Membre , Lieu, Objet } from '../models/game.service';

@Injectable({
  providedIn: 'root'
})
export class OrgaApiService {

  groupe: string = 'http://localhost:8080/api/v1/groupes';
  membre:string = 'http://localhost:8080/api/v1/membres';
  personnage:string = 'http://localhost:8080/api/v1/personnages';
  lieu:string = 'http://localhost:8080/api/v1/lieux';
  objet:string = 'http://localhost:8080/api/v1/objets';

  constructor(private http: HttpClient) { }

  // Groupe 
  getAllGroupes(jeu:string): Observable<Groupe[]> {
    return this.http.get<Groupe[]>(this.groupe+"/jeu/"+jeu);
  }

  createGroupe(Groupe:any): Observable<Groupe> {
    return this.http.post<any>(this.groupe,Groupe)
  }

  deleteGroupe(id:string): Observable<Groupe> {
    return this.http.delete<Groupe>(this.groupe+'/'+id);
  }

  editGroupe(Groupe:Groupe): Observable<Groupe>{
    return this.http.put<any>(this.groupe+'/'+Groupe.id_groupe,Groupe);
  }

  // Membre
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

  // Personnage
  getAllPersonnage(jeu:string): Observable<Personnage[]>{
    return this.http.get<Personnage[]>(this.personnage+"/jeu/"+jeu);
  }

  getPersonnage(id:string): Observable<Personnage>{
    return this.http.get<Personnage>(this.personnage+"/"+id);;
  }

  // Lieu
  getAllLieux(jeu:string): Observable<Lieu[]> {
    return this.http.get<Lieu[]>(this.lieu+"/jeu/"+jeu);
  }

  createLieu(Lieu:any): Observable<Lieu> {
    return this.http.post<any>(this.lieu,Lieu)
  }

  deleteLieu(id:string): Observable<Lieu> {
    return this.http.delete<Lieu>(this.lieu+'/'+id);
  }

  editLieu(Lieu:Lieu): Observable<Lieu>{
    return this.http.put<any>(this.lieu+'/'+Lieu.id_lieu,Lieu);
  }

  // Objet
  getAllObjets(jeu:string): Observable<Objet[]> {
    return this.http.get<Objet[]>(this.objet+"/jeu/"+jeu);
  }

  createObjet(objet:any): Observable<Objet> {
    return this.http.post<any>(this.objet,objet)
  }

  deleteObjet(id:string): Observable<Objet> {
    return this.http.delete<Objet>(this.objet+'/'+id);
  }

  editObjet(objet:Objet): Observable<Objet>{
    console.log(objet.id_Objet);
    return this.http.put<any>(this.objet+'/'+objet.id_Objet,objet);
  }
}
