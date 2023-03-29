package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.UtilisateurSupport;

public class UtilisateurSupportDao extends AbstractJpaDao<Integer, fr.istic.taa.jaxrs.domain.UtilisateurSupport>{

    public UtilisateurSupportDao(){
        super(UtilisateurSupport.class);
    }
}
