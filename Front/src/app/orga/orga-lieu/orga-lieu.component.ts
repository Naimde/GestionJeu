import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { OrgaApiService } from 'src/app/api/orga-api.service';
import { Lieu, Personnage } from 'src/app/models/game.service';

@Component({
  selector: 'app-orga-lieu',
  templateUrl: './orga-lieu.component.html',
  styleUrls: ['./orga-lieu.component.scss']
})
export class OrgaLieuComponent implements OnInit {
  display:any;
  LieuAffiche:number=1;
  lieux:Lieu[]=[];
  Addform!:UntypedFormGroup;
  Membreform!:UntypedFormGroup;
  Personnages:Personnage[]=[];
  PersoSelect!:string;

  constructor(
    private api: OrgaApiService, private formbuilder:UntypedFormBuilder
  ) {
  }

  ngOnInit() {
    this.loadAllLieux();
    this.recupPersonnage();
    this.Addform = this.formbuilder.group({
      genre:['',Validators.required],
      nom:['',Validators.required],
      description:[''],
      jeu:[localStorage.getItem("jeu")]
    });
  }

  deleteLieu(group: Lieu) {
    this.api.deleteLieu(group.id_lieu).subscribe(() => {this.loadAllLieux();this.display=false});
  }

  loadAllLieux() {
    this.api.getAllLieux(localStorage.getItem("jeu")!).subscribe(Lieux => this.lieux = Lieux);
  }

  createLieu(){
    if (this.Addform.valid) {
      this.Addform.controls["jeu"].setValue(localStorage.getItem("jeu"));
      this.api.createLieu(this.Addform.value).subscribe(() => this.loadAllLieux());this.Addform.reset();
    }
  }

  enregistrerLieu(Lieu:Lieu){
    this.api.editLieu(Lieu).subscribe();
  }

  afficheLateral(index:number){
    this.display=true;
    this.LieuAffiche=index;
    this.Membreform.reset();
  }

  recupPersonnage(){
    this.api.getAllPersonnage(localStorage.getItem("jeu")!).subscribe(x=>this.Personnages=x);
  }
}

