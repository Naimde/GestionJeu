import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {TabViewModule} from 'primeng/tabview';
import {CardModule} from 'primeng/card';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {RippleModule} from 'primeng/ripple';
import {SidebarModule} from 'primeng/sidebar';
import {ToggleButtonModule} from 'primeng/togglebutton';



import { AppComponent } from './app.component';
import {ConnuCardComponent} from './connu-card/connu-card.component';
import { PjComponent } from './pj/pj.component';
import { OrgaComponent } from './orga/orga.component';
import { AdminComponent } from './admin/admin.component';
import { PersoConnuComponent } from './pj/perso-connu/perso-connu.component';
import { GroupeConnuComponent } from './pj/groupe-connu/groupe-connu.component';
import { LieuConnuComponent } from './pj/lieu-connu/lieu-connu.component';
import { ConnectComponent } from './tmp/connect/connect.component';
import { AuthInterceptor } from './helpers/auth-interceptor.service';
import { appRoutingModule } from './app.routing';
import { LoginComponent } from './account/login/login.component';
import { RegisterComponent } from './account/register/register.component';
import { HomeComponent } from './home/home.component';
import { OrgaPersonnageComponent } from './orga/orga-personnage/orga-personnage.component';
import { OrgaGroupeComponent } from './orga/orga-groupe/orga-groupe.component';
import { AfficheMembreComponent } from './orga/orga-groupe/affiche-membre/affiche-membre.component';
import { PersoNomComponent } from './helpers/perso-nom/perso-nom.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnuCardComponent,
    PjComponent,
    OrgaComponent,
    AdminComponent,
    PersoConnuComponent,
    GroupeConnuComponent,
    LieuConnuComponent,
    ConnectComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    OrgaPersonnageComponent,
    OrgaGroupeComponent,
    AfficheMembreComponent,
    PersoNomComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ButtonModule,
    InputTextModule,
    TabViewModule,
    CardModule,
    ScrollPanelModule,
    HttpClientModule,
    RippleModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    SidebarModule,
    appRoutingModule,
    ToggleButtonModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },],
  bootstrap: [AppComponent]
})
export class AppModule { }
