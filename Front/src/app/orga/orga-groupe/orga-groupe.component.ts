import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrgaApiService } from 'src/app/api/orga-api.service';
import { Groupe, Membre, Personnage } from 'src/app/models/game.service';

@Component({
  selector: 'app-orga-groupe',
  templateUrl: './orga-groupe.component.html',
  styleUrls: ['./orga-groupe.component.scss']
})
export class OrgaGroupeComponent implements OnInit {
  display:any;
  groupeAffiche:number=1;
  groups:Groupe[]=[];
  Addform!:FormGroup;
  Personnages:Personnage[]=[];
  PersoSelect!:string;
  membres:Membre[]=[];

  constructor(
    private api: OrgaApiService, private formbuilder:FormBuilder
  ) {
  }

  ngOnInit() {
    this.loadAllGroups();
    this.recupPersonnage();
    this.Addform = this.formbuilder.group({
      genre:['',Validators.required],
      nom:['',Validators.required],
      description:[''],
      jeu:[localStorage.getItem("jeu")]
    })
  }

  deleteGroupe(group: Groupe) {
    this.api.deleteGroupe(group.id_groupe).subscribe(() => this.loadAllGroups());
  }

  loadAllGroups() {
    this.api.getAll(localStorage.getItem("jeu")!).subscribe(Groupes => this.groups = Groupes);
  }

  createGroupe(){
    if (this.Addform.valid) {
      this.Addform.controls["jeu"].setValue(localStorage.getItem("jeu"));
      this.api.createGroupe(this.Addform.value).subscribe(() => this.loadAllGroups());this.Addform.reset();
    }
  }

  enregistrerGroupe(Groupe:Groupe){
    this.api.editGroupe(Groupe).subscribe();
  }

  afficheLateral(index:number){
    this.display=true;
    this.groupeAffiche=index;
    this.trouveMembre(this.groups[index]);
    this.PersoSelect="";
  }

  recupPersonnage(){
    this.api.getAllPersonnage(localStorage.getItem("jeu")!).subscribe(x=>this.Personnages=x);
  }

  trouveMembre(groupe:Groupe){
    this.api.trouveMembre(groupe.id_groupe).subscribe(x => {this.membres=x});
  }

  isNotMember(perso:Personnage): Boolean{
    if(this.membres.find(e => e.idPersonnage === perso.id_personnage))
      return false;
    return true;
  }
}
