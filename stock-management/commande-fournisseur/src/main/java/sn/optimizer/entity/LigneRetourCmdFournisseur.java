package sn.optimizer.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="lignes_retour_cmd_fournisseur")
public class LigneRetourCmdFournisseur {

    @Id
    @SequenceGenerator(name="ligne_retour_cmd_fournisseur_id_sequence",
            sequenceName="ligne_retour_cmd_fournisseur_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ligne_retour_cmd_fournisseur_id_sequence")
    private Long id;

    @Column(name="quantite_retourne", nullable=false)
    private float quantiteRetourne;

    public LigneRetourCmdFournisseur() {}

    public Long getId() {
        return id;
    }

    public float getQuantiteRetourne() {
        return quantiteRetourne;
    }

    public void setQuantiteRetourne(float quantiteRetourne) {
        this.quantiteRetourne = quantiteRetourne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LigneRetourCmdFournisseur that)) return false;
        return Float.compare(quantiteRetourne, that.quantiteRetourne) == 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantiteRetourne);
    }
}
