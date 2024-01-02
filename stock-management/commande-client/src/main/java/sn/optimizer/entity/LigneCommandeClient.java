package sn.optimizer.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="lignes_commande_client")
public class LigneCommandeClient {

    @Id
    @SequenceGenerator(name="ligne_commande_client_id_sequence",
            sequenceName="ligne_commande_client_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ligne_commande_client_id_sequence")
    private Long id;

    @Column(name="quantite", nullable=false)
    private float quantite;

    @Column(name="livre", columnDefinition="bool not null default false")
    private boolean livre;

    public LigneCommandeClient(){}

    public LigneCommandeClient(Long id, float quantite, boolean livre) {
        this.id = id;
        this.quantite = quantite;
        this.livre = livre;
    }

    public LigneCommandeClient(float quantite, boolean livre) {
        this.quantite = quantite;
        this.livre = livre;
    }

    public Long getId() {
        return id;
    }

    public float getQuantite() {
        return quantite;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LigneCommandeClient that)) return false;
        return Float.compare(quantite, that.quantite) == 0 && livre == that.livre && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantite, livre);
    }
}
