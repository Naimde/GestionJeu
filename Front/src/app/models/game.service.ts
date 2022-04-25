export class Groupe {
  id_groupe:string;
  genre:string;
  nom:string;
  description:string;
  visionautre:Boolean;
  leader:string;
  jeu:string;

  constructor(id_groupe:string,
    genre:string,
    nom:string,
    description:string,
    visionautre:Boolean,
    leader:string,
    jeu:string
    ){
      this.id_groupe=id_groupe;
      this.genre=genre;
      this.nom=nom;
      this.description=description;
      this.visionautre=visionautre;
      this.leader=leader;
      this.jeu=jeu;
  }
}

export class Membre {
  idGroupe:string;
  idPersonnage:string;
  description:string;

  constructor(id_groupe:string,
    id_personnage:string,
    description:string)
    {
      this.idGroupe=id_groupe;
      this.idPersonnage=id_personnage;
      this.description=description;
  }
}

export class Personnage {
  
}