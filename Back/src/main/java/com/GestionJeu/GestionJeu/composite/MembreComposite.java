package com.GestionJeu.GestionJeu.composite;

import java.io.Serializable;

public class MembreComposite implements Serializable {
        String idGroupe;
        String idPersonnage;
        
        public MembreComposite(String idGroupe, String idPersonnage) {
            this.idPersonnage = idPersonnage;
            this.idGroupe = idGroupe;
        }

        public MembreComposite() {
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((idGroupe == null) ? 0 : idGroupe.hashCode());
            result = prime * result + ((idPersonnage == null) ? 0 : idPersonnage.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MembreComposite other = (MembreComposite) obj;
            if (idGroupe == null) {
                if (other.idGroupe != null)
                    return false;
            } else if (!idGroupe.equals(other.idGroupe))
                return false;
            if (idPersonnage == null) {
                if (other.idPersonnage != null)
                    return false;
            } else if (!idPersonnage.equals(other.idPersonnage))
                return false;
            return true;
        }
    
}
