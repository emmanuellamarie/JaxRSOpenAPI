package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Ticket;

public class TicketDao extends AbstractJpaDao<Integer, fr.istic.taa.jaxrs.domain.Ticket>{

    public TicketDao(){
        super(Ticket.class);
    }
}
