import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrgaApiService } from 'src/app/api/orga-api.service';
import { Groupe, Membre } from 'src/app/models/game.service';

@Component({
  selector: 'app-affiche-membre',
  templateUrl: './affiche-membre.component.html',
  styleUrls: ['./affiche-membre.component.scss']
})
export class AfficheMembreComponent implements OnInit {
  membres:Membre[]=[];
  Addform!:FormGroup;

  @Input() groupe!:Groupe;

  constructor(
    private api: OrgaApiService, private formbuilder:FormBuilder
  ) {
  }

  ngOnInit() {
     this.trouveMembre(this.groupe);
    
    this.Addform = this.formbuilder.group({
      id_personnage:['',Validators.required],
      description:['']
    })
  }

/*   deleteGroupe(group: Groupe) {
    this.api.deleteGroupe(group.id_groupe).subscribe(() => this.loadAllGroups());
  } */

/*   loadAllGroups() {
    this.api.getAll(localStorage.getItem("jeu")!).subscribe(Groupes => this.groups = Groupes);
  } */

/*   createGroupe(){
    if (this.Addform.valid) {
      this.Addform.controls["jeu"].setValue(localStorage.getItem("jeu"));
      this.api.createGroupe(this.Addform.value).subscribe(() => this.loadAllGroups());this.Addform.reset();
    }
  } */

/*   enregistrerGroupe(Groupe:Groupe){
    this.api.editGroupe(Groupe).subscribe(() => this.loadAllGroups());
  } */

  trouveMembre(groupe:Groupe){
    this.api.trouveMembre(groupe.id_groupe).subscribe(x => {this.membres=x; console.log(this.membres)});
  }
}
