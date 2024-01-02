package sn.optimizer.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="produit_type", discriminatorType=DiscriminatorType.STRING)
@Table(name="produits", uniqueConstraints={
        @UniqueConstraint(name="UQ_PRODUITS_DESIGNATION", columnNames={"designation"})
})
public class Produit{

    @Id
    @SequenceGenerator(name="produit_id_sequence",
            sequenceName="produit_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produit_id_sequence")
    protected Long id;

    @Column(name="designation", columnDefinition="varchar(150) not null")
    protected String designation;

    @Column(name="description")
    protected String description;

    @Column(name="prix_unitaire", columnDefinition="float not null")
    protected float prixUnitaire;

    public Produit() {}

    public Produit(Long id, String designation,
                   String description, float prixUnitaire) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.prixUnitaire = prixUnitaire;
    }

    public Produit(String designation, String description,
                   float prixUnitaire) {
        this.designation = designation;
        this.description = description;
        this.prixUnitaire = prixUnitaire;
    }

    public Long getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produit produit)) return false;
        return Float.compare(prixUnitaire, produit.prixUnitaire) == 0 && Objects.equals(id, produit.id)
                && Objects.equals(designation, produit.designation)
                && Objects.equals(description, produit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, description, prixUnitaire);
    }
}