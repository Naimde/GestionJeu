package com.GestionJeu.GestionJeu.composite;

import java.io.Serializable;

public class ConnuComposite implements Serializable {
        String idPersonnage;
        String idCible;
        
        public ConnuComposite(String idPersonnage, String idCible) {
            this.idPersonnage = idPersonnage;
            this.idCible = idCible;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((idCible == null) ? 0 : idCible.hashCode());
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
            ConnuComposite other = (ConnuComposite) obj;
            if (idCible == null) {
                if (other.idCible != null)
                    return false;
            } else if (!idCible.equals(other.idCible))
                return false;
            if (idPersonnage == null) {
                if (other.idPersonnage != null)
                    return false;
            } else if (!idPersonnage.equals(other.idPersonnage))
                return false;
            return true;
        }
    
}
