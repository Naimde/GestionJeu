export class Groupe {
  id_groupe!:string;
  genre!:string;
  nom!:string;
  description!:string;
  visionautre!:Boolean;
  leader!:string;
  jeu!:string;
}

export class Membre {
  idGroupe!:string;
  idPersonnage!:string;
  description!:string;
}

export class Personnage {
  id_personnage!:string;
  id_reelle!:string;
  nom!:string;
  prenom!:string;
  surnom!:string;
  genre!:string;
  naissance!:Date;
  localisation!:string;
  background!:string;
  info_public!:string;
}

export class Lieu {
  id_lieu!:string;
  genre!:string;
  nom!:string;
  description!:string;
  jeu!:string;
}

export class Objet {
  id_Objet!:string;
  nom!:string;
  description!:string;
  possesseur!:string;
  jeu!:string;
}

export class Image{
  ID!:string;
  image!:string;
}