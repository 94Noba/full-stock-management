package sn.optimizer.store.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="types_mvt_stock", uniqueConstraints={
        @UniqueConstraint(name="UQ_TYPES_MVT_STOCK_LIBELLE", columnNames={"libelle"})
})
public class TypeMvtStock {

    @Id
    @SequenceGenerator(name="type_mvt_stock_id_sequence",
            sequenceName="type_mvt_stock_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="type_mvt_stock_id_sequence")
    private Long id;

    @Column(name="libelle", length=50, nullable=false)
    private String libelle;

    public TypeMvtStock() {}

    public TypeMvtStock(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public TypeMvtStock(String libelle) {
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeMvtStock that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
    }
}
