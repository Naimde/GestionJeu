import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConnectApiService } from '../api/connect-api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  autorisation: any[] = [];

  constructor(private router: Router, private connect : ConnectApiService) { }

  ngOnInit(): void {
    this.connect.getReturn().subscribe(data => {this.autorisation=data.authorities;
    });
  }

  aller(name: string){
    if(name=="ROLE_ADMIN")
      this.router.navigate(['/admin']);
    if(name.endsWith("-pj")){
      localStorage.setItem("jeu",name.substring(0,name.length-3));
      this.router.navigate(['/jeu']);}
    if(name.endsWith("-orga")){
      localStorage.setItem("jeu",name.substring(0,name.length-5));
      this.router.navigate(['/orga-jeu']);}
  }

  genre(name:string){
    if(name=="ROLE_ADMIN")
      return "admin";
    if(name.endsWith("-pj"))
      return "jeu";
    if(name.endsWith("-orga"))
      return "orga-jeu";
    return "error";
  }
}
