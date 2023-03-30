package fr.istic.taa.jaxrs.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UtilisateurSupport extends Utilisateur {

    private String equipe;
    private List<Ticket> ticketList = new ArrayList<Ticket>();


    public UtilisateurSupport() {

        super();
    }

    public UtilisateurSupport(String nom, String prenom){
        super(nom,prenom);
        this.equipe = "équipe";
    }

    @OneToMany(mappedBy = "utilisateurSupport", cascade = CascadeType.PERSIST)
    @JsonManagedReference(value = "utilisateurSupport-ticket")
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
}
