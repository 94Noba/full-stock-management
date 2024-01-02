package sn.optimizer.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="commandes_fournisseur")
public class CommandeFournisseur {

    @Id
    @SequenceGenerator(name = "cmd_fournisseur_id_sequence",
            sequenceName = "cmd_fournisseur_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cmd_fournisseur_id_sequence")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="date_commande", nullable = false)
    private LocalDate dateCommande;

    public CommandeFournisseur(){}

    public CommandeFournisseur(LocalDate dateCommande){
        this.dateCommande=dateCommande;
    }

    public CommandeFournisseur(Long id, LocalDate dateCommande) {
        this.id = id;
        this.dateCommande = dateCommande;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandeFournisseur that = (CommandeFournisseur) o;
        return Objects.equals(id, that.id) && Objects.equals(dateCommande, that.dateCommande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCommande);
    }
}
