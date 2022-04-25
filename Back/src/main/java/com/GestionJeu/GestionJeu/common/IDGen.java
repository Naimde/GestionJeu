package com.GestionJeu.GestionJeu.common;

public class IDGen {

    static private String gen(String raccourci){
        String concat = raccourci.substring(0,4).toUpperCase()+"-";
        String alea ="ABCDEFGHIJKLMNOPQRSTUVWXYZ_zyxwvutsrqponmlkjihgfedcba";
        while(concat.length()<20){
            concat+=alea.charAt((int)(Math.random()*alea.length()));
        }
        return concat;
    }

    static public String personnage(){
        return gen("Personnage");
    }

    static public String lieu(){
        return gen("Lieu");
    }

    static public String secret(){
        return gen("Secret");
    }

    static public String action(){
        return gen("Action");
    }
    static public String objet(){
        return gen("Objet");
    }

    static public String groupe(String genre){
        return gen("GR"+genre);
    }

    static public String whatType(String ID){
        switch(ID.substring(0,4)){
            case "PERS":
               return "Personnage";
            case "LIEU":
                return "Lieu";
            case "SECR":
                return "Secret";
            case "ACTI":
                return "Action";
            case "OBJE":
                return "Objet";
            default:
                return "Groupe";
        }
    }
}
