import { Component, OnInit } from '@angular/core';
import { ConnectApiService } from '../../api/connect-api.service';

@Component({
  selector: 'app-connect',
  templateUrl: './connect.component.html',
  styleUrls: ['./connect.component.scss']
})
export class ConnectComponent implements OnInit {

  login:String = "Naimde";
  password:String = "test";
  tokemtext:any=localStorage.getItem("token");
  loginRecup:String="";

  constructor(private api:ConnectApiService
  ) {
  }

  ngOnInit() {
  }

  getToken(): void {
    this.api.getToken(this.login,this.password).subscribe(token => {
        this.tokemtext=token.accessToken;
        localStorage.setItem("token",token.accessToken);
        localStorage.setItem("expiration",token.expiresAt);
    });
  }

  getMe(): void {
    this.api.getReturn().subscribe(user => {
      this.loginRecup=JSON.stringify(user);
    });
  }
}
