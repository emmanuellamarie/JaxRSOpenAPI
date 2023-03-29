package fr.istic.taa.jaxrs.domain;



import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class UtilisateurStandard extends Utilisateur {

    private List<Ticket> ticketList = new ArrayList<Ticket>();

    public UtilisateurStandard(){

        super();
    }

    public UtilisateurStandard(String nom, String prenom){
        super(nom,prenom);
    }

    @OneToMany(mappedBy = "utilisateurStandard", cascade = CascadeType.PERSIST)
    @JsonBackReference
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
