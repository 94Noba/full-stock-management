package sn.optimizer.store.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="mouvements_stock")
public class MouvementStock {

    @Id
    @SequenceGenerator(name="mouvement_stock_id_sequence",
            sequenceName="mouvement_stock_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mouvement_stock_id_sequence")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="date_mouvement", nullable=false)
    private LocalDate dateMouvement;

    public MouvementStock() {}

    public MouvementStock(Long id, LocalDate dateMouvement) {
        this.id = id;
        this.dateMouvement = dateMouvement;
    }

    public MouvementStock(LocalDate dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(LocalDate dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MouvementStock that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(dateMouvement, that.dateMouvement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateMouvement);
    }
}
