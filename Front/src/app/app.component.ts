import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { PrimeNGConfig } from 'primeng/api';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  constructor(
        private router: Router,
        private primengConfig: PrimeNGConfig
    ) {  }

    ngOnInit() {
        this.primengConfig.ripple = true;
    }

    retour(){
        localStorage.removeItem("jeu")
        this.router.navigate(['']);
    }

    logOut(){
        localStorage.clear(); 
        this.router.navigate(['login']);
    }

    loggedIn(){
        if(localStorage.getItem("token"))
            return true;
        return false;
    }
}