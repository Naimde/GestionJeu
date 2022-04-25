package com.GestionJeu.GestionJeu.composite;

import java.io.Serializable;

public class JeuComposite implements Serializable {
        String jeu;
        String user;
        
        public JeuComposite(String jeu, String user) {
            this.user = user;
            this.jeu = jeu;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((jeu == null) ? 0 : jeu.hashCode());
            result = prime * result + ((user == null) ? 0 : user.hashCode());
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
            JeuComposite other = (JeuComposite) obj;
            if (jeu == null) {
                if (other.jeu != null)
                    return false;
            } else if (!jeu.equals(other.jeu))
                return false;
            if (user == null) {
                if (other.user != null)
                    return false;
            } else if (!user.equals(other.user))
                return false;
            return true;
        }
    
}
