package sn.optimizer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue(value = "FABRIQUER")
public class ProduitFabriquer extends Produit{

    @Column(name="cout_unitaire")
    private float coutUnitaire;

    public ProduitFabriquer() {}

    public ProduitFabriquer(float cout_unitaire) {
        this.coutUnitaire = cout_unitaire;
    }

    public ProduitFabriquer(Long id, String designation,
                            String description, float prixUnitaire,
                            float cout_unitaire) {
        super(id, designation, description, prixUnitaire);
        this.coutUnitaire = cout_unitaire;
    }

    public ProduitFabriquer(String designation, String description,
                            float prixUnitaire, float cout_unitaire) {
        super(designation, description, prixUnitaire);
        this.coutUnitaire = cout_unitaire;
    }

    public float getCoutUnitaire() {
        return coutUnitaire;
    }

    public void setCoutUnitaire(float cout_unitaire) {
        this.coutUnitaire = cout_unitaire;
    }
}
