package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Sujet;

public class SujetDao extends AbstractJpaDao<Integer, fr.istic.taa.jaxrs.domain.Sujet>{

    public SujetDao(){
        super(Sujet.class);
    }
}
