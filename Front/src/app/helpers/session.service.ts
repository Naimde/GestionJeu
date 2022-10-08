import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  jeu:string;
  expiration:number=Date.now();
  token:string;

  constructor() { 
    this.expiration=Date.parse(String(localStorage.getItem("expiration")));
    this.token=String(localStorage.getItem("token"));
    this.jeu=String(localStorage.getItem("jeu"));
    localStorage.clear();
  }

  ngOnDestroy(){
    localStorage.setItem("expiration",this.expiration.toString());
    localStorage.setItem("token",this.token);
    localStorage.setItem("jeu",this.jeu);
}
}
