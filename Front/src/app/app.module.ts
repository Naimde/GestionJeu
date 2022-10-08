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
import {InputTextareaModule} from 'primeng/inputtextarea';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {FileUploadModule} from 'primeng/fileupload';
import {TableModule} from 'primeng/table';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ConfirmationService} from 'primeng/api';
import {DialogModule} from 'primeng/dialog';



import { AppComponent } from './app.component';
import {ConnuCardComponent} from './connu-card/connu-card.component';
import { PjComponent } from './pj/pj.component';
import { OrgaComponent } from './orga/orga.component';
import { AdminComponent } from './admin/admin.component';
import { PersoConnuComponent } from './pj/perso-connu/perso-connu.component';
import { GroupeConnuComponent } from './pj/groupe-connu/groupe-connu.component';
import { LieuConnuComponent } from './pj/lieu-connu/lieu-connu.component';
import { AuthInterceptor } from './helpers/auth-interceptor.service';
import { appRoutingModule } from './app.routing';
import { LoginComponent } from './account/login/login.component';
import { RegisterComponent } from './account/register/register.component';
import { HomeComponent } from './home/home.component';
import { OrgaPersonnageComponent } from './orga/orga-personnage/orga-personnage.component';
import { OrgaGroupeComponent } from './orga/orga-groupe/orga-groupe.component';
import { AfficheMembreComponent } from './orga/orga-groupe/affiche-membre/affiche-membre.component';
import { PersoNomComponent } from './helpers/perso-nom/perso-nom.component';
import { OrgaLieuComponent } from './orga/orga-lieu/orga-lieu.component';
import { OrgaObjetComponent } from './orga/orga-objet/orga-objet.component';

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
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    OrgaPersonnageComponent,
    OrgaGroupeComponent,
    AfficheMembreComponent,
    PersoNomComponent,
    OrgaLieuComponent,
    OrgaObjetComponent
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
    ToggleButtonModule,
    InputTextareaModule,
    MessagesModule,
    MessageModule,
    ToastModule,
    ToolbarModule,
    FileUploadModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    ConfirmationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
