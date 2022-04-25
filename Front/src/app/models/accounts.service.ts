export class User {
  username:string;
  password:string;
  mail:string;
  roles:Role[];

  constructor( username:string,
    password:string,
    mail:string,
    roles:Role[],
  ) {
    this.username=username;
    this.password=password;
    this.mail=mail;
    this.roles=roles;
  }
}

export class Role {
  id:number;
  name:string;
  authority:string;

  constructor(id:number,
    name:string,
    authority:string) {
  this.id=id;
  this.name=name;
  this.authority=authority;
  }
}

export class Token{
  accessToken:string;
  authorities:string[];
  issuedAt:Date;
  expiresAt:Date;

  constructor(
    accessToken:string,
    authorities:string[],
    issuedAt:Date,
    expiresAt:Date
  ){
    this.accessToken=accessToken;
    this.authorities=authorities;
    this.issuedAt=issuedAt;
    this.expiresAt=expiresAt;
  }
}