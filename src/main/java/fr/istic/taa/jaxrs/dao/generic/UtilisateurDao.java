package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<Integer, fr.istic.taa.jaxrs.domain.Utilisateur>{

    public UtilisateurDao(){
        super(Utilisateur.class);
    }
}
