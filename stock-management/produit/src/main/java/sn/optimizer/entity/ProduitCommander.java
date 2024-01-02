package sn.optimizer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="COMMANDER")
public class ProduitCommander extends Produit{

    @Column(name="prix_achat_unitaire")
    private float prixAchatUnitaire;

    public ProduitCommander() {}

    public ProduitCommander(float prixAchatUnitaire) {
        this.prixAchatUnitaire = prixAchatUnitaire;
    }

    public ProduitCommander(Long id, String designation, String description,
                            float prixUnitaire, float prixAchatUnitaire) {
        super(id, designation, description, prixUnitaire);
        this.prixAchatUnitaire = prixAchatUnitaire;
    }

    public ProduitCommander(String designation, String description,
                            float prixUnitaire, float prixAchatUnitaire) {
        super(designation, description, prixUnitaire);
        this.prixAchatUnitaire = prixAchatUnitaire;
    }

    public float getPrixAchatUnitaire() {
        return prixAchatUnitaire;
    }

    public void setPrixAchatUnitaire(float prixAchatUnitaire) {
        this.prixAchatUnitaire = prixAchatUnitaire;
    }
}
