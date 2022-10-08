import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { AdminApiService } from '../api/admin-api.service';
import { Role, User } from '../models/accounts.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  display:any;
  users:User[]=[];
  roleList:Role[] = [];
  Addform!:UntypedFormGroup;
  gameName:string="";

  constructor(
    private api: AdminApiService, private formbuilder:UntypedFormBuilder
  ) {
  }

  ngOnInit() {
    this.loadAllUsers();
    
    this.Addform = this.formbuilder.group({
      username:['',Validators.required],
      mail:['',Validators.required],
      password:['',Validators.required]
    })
  }

  deleteUser(id: string) {
    this.api.deleteUser(id).subscribe(() => this.loadAllUsers());
  }

  loadAllUsers() {
    this.listRoles();
    this.api.getAll().subscribe(users => this.users = users);
  }

  createUser(){
    if (this.Addform.valid) {
      this.api.createUser(this.Addform.value).subscribe(() => this.loadAllUsers());
      this.Addform.reset();
    }
  }

  enregistrerUser(user:User){
    this.api.editUser(user).subscribe(() => this.loadAllUsers());
  }

  createGame(){
    this.api.createGame(this.gameName+"-pj").subscribe();
    this.api.createGame(this.gameName+"-orga").subscribe();
    this.loadAllUsers();
    this.gameName="";
    this.display=false;
  }

  deleteRole(name:string,role:any){
    this.api.deleteRole(name,role.id).subscribe(() => this.loadAllUsers());
  }

  addRole(name:string,role:any){
    this.api.addRole(name,role.id).subscribe(() => this.loadAllUsers());
  }

  listRoles(){
    this.api.listRoles().subscribe(roles => this.roleList = roles);
  }

  isNotInUserRole(role:Role,user:User): Boolean{
    if(user.roles.find(e => e.id === role.id))
      return false;
    return true;
  }
}
