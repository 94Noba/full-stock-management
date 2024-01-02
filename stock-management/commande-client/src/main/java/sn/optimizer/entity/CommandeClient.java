package sn.optimizer.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="commandes_client")
public class CommandeClient {

    @Id
    @SequenceGenerator(name="cmd_client_id_sequence",
            sequenceName="cmd_client_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cmd_client_id_sequence")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="date_commande", nullable = false)
    private LocalDate dateCommande;

    public CommandeClient(){}

    public CommandeClient(Long id, LocalDate dateCommande) {
        this.id = id;
        this.dateCommande = dateCommande;
    }

    public CommandeClient(LocalDate dateCommande) {
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
        CommandeClient that = (CommandeClient) o;
        return Objects.equals(id, that.id) && Objects.equals(dateCommande, that.dateCommande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCommande);
    }
}
