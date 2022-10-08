import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrgaApiService } from 'src/app/api/orga-api.service';
import { Objet, Lieu, Personnage } from 'src/app/models/game.service';

@Component({
  selector: 'app-orga-objet',
  templateUrl: './orga-objet.component.html',
  styleUrls: ['./orga-objet.component.scss']
})
export class OrgaObjetComponent implements OnInit {
  display:any;
  ObjetAffiche:number=1;
  objets:Objet[]=[];
  Addform!:FormGroup;
  Personnages:Personnage[]=[];
  PersoSelect!:string;

  constructor(
    private api: OrgaApiService, private formbuilder:FormBuilder
  ) {
  }

  ngOnInit() {
    this.loadAllObjets();
    this.recupPersonnage();
    this.Addform = this.formbuilder.group({
      nom:['',Validators.required],
      description:[''],
      jeu:[localStorage.getItem("jeu")]
    });
  }

  deleteObjet(Objet: Objet) {
    this.api.deleteObjet(Objet.id_Objet).subscribe(() => {this.loadAllObjets();this.display=false});
  }

  loadAllObjets() {
    this.api.getAllObjets(localStorage.getItem("jeu")!).subscribe(Objets => this.objets = Objets);
  }

  createObjet(){
    if (this.Addform.valid) {
      this.Addform.controls["jeu"].setValue(localStorage.getItem("jeu"));
      this.api.createObjet(this.Addform.value).subscribe(() => this.loadAllObjets());this.Addform.reset();
    }
  }

  enregistrerObjet(Objet:Objet){
    this.api.editObjet(Objet).subscribe();
    console.log(Objet);
  }

  afficheLateral(index:number){
    this.display=true;
    this.ObjetAffiche=index;
  }

  recupPersonnage(){
    this.api.getAllPersonnage(localStorage.getItem("jeu")!).subscribe(x=>this.Personnages=x);
  }
}


