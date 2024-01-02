package sn.optimizer.store.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="lignes_mvt_stock")
public class LigneMvtStock {

    @Id
    @SequenceGenerator(name="ligne_mvt_stock_id_sequence",
            sequenceName="ligne_mvt_stock_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ligne_mvt_stock_id_sequence")
    private Long id;

    @Column(name="quantite", columnDefinition="float not null")
    private float quantite;

    public LigneMvtStock() {}

    public LigneMvtStock(Long id, float quantite) {
        this.id = id;
        this.quantite = quantite;
    }

    public LigneMvtStock(float quantite) {
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LigneMvtStock that)) return false;
        return Float.compare(quantite, that.quantite) == 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantite);
    }
}
