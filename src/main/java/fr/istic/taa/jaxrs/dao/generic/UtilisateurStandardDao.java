package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.UtilisateurStandard;



public class UtilisateurStandardDao extends AbstractJpaDao<Integer, UtilisateurStandard>{

    public UtilisateurStandardDao(){
        super(UtilisateurStandard.class);
    }
}
