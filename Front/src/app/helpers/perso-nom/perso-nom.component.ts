import { Component, Input, OnInit } from '@angular/core';
import { OrgaApiService } from 'src/app/api/orga-api.service';
import { Personnage } from 'src/app/models/game.service';

@Component({
  selector: 'app-perso-nom',
  templateUrl: './perso-nom.component.html',
  styleUrls: ['./perso-nom.component.scss']
})
export class PersoNomComponent implements OnInit {

  @Input() id!:string;
  CePersonnage!:Personnage;

  constructor(private api: OrgaApiService) { }

  ngOnInit(): void {
    this.getPersonnage();
  }

  getPersonnage(){
    this.api.getPersonnage(this.id).subscribe(x=>{
      this.CePersonnage=x
    });
  }
}
