import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrgaApiService } from 'src/app/api/orga-api.service';
import { Groupe, Membre } from 'src/app/models/game.service';

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

  constructor(
    private api: OrgaApiService, private formbuilder:FormBuilder
  ) {
  }

  ngOnInit() {
    this.loadAllGroups();
    
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
    this.api.editGroupe(Groupe).subscribe(() => this.loadAllGroups());
  }

  afficheLateral(index:number){
    this.display=true;
    this.groupeAffiche=index;
    console.log(this.groupeAffiche)
  }

}
