package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Commentaire;

public class CommentaireDao extends AbstractJpaDao<Integer, fr.istic.taa.jaxrs.domain.Commentaire>{

    public CommentaireDao(){
        super(Commentaire.class);
    }

}
