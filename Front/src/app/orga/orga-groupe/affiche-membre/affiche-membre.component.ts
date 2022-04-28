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
  @Input() vision:Boolean=true;
  @Input() action:Boolean=false;

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

  deleteMembre(membre: Membre) {
    this.api.deleteMembre(membre).subscribe(()=>this.trouveMembre(this.groupe));
  }

/*   loadAllGroups() {
    this.api.getAll(localStorage.getItem("jeu")!).subscribe(Groupes => this.groups = Groupes);
  } */

/*   createGroupe(){
    if (this.Addform.valid) {
      this.Addform.controls["jeu"].setValue(localStorage.getItem("jeu"));
      this.api.createGroupe(this.Addform.value).subscribe(() => this.loadAllGroups());this.Addform.reset();
    }
  } */

  enregistrerChange(membre:Membre){
    this.api.editMembre(membre).subscribe();
  }

  trouveMembre(groupe:Groupe){
    this.api.trouveMembre(groupe.id_groupe).subscribe(x => {this.membres=x;});
  }
}
