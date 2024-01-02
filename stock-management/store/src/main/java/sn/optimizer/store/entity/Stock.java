package sn.optimizer.store.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="stocks", uniqueConstraints = {
        @UniqueConstraint(name="UQ_STOCKS_NOM", columnNames={"nom"}),
        @UniqueConstraint(name="UQ_STOCKS_TELEPHONE", columnNames={"telephone"})
})
public class Stock {

    @Id
    @SequenceGenerator(name = "stocks_id_sequence",
            sequenceName = "stocks_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stocks_id_sequence")
    private Long id;

    @Column(name="nom", columnDefinition = "varchar not null")
    private String nom;

    @Column(name="telephone", columnDefinition = "varchar(50) not null")
    private String telephone;

    @Column(name="telephone1", columnDefinition = "varchar(50)")
    private String telephone1;

    @Column(name = "addresse", columnDefinition = "varchar not null")
    private String addresse;

    public Stock(){}

    public Stock(Long id, String nom,
                 String telephone, String telephone1,
                 String addresse) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.telephone1 = telephone1;
        this.addresse = addresse;
    }

    public Stock(String nom, String telephone,
                 String telephone1, String addresse) {
        this.nom = nom;
        this.telephone = telephone;
        this.telephone1 = telephone1;
        this.addresse = addresse;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        if (!id.equals(stock.id)) return false;
        if (!nom.equals(stock.nom)) return false;
        if (!telephone.equals(stock.telephone)) return false;
        if (!Objects.equals(telephone1, stock.telephone1)) return false;
        return addresse.equals(stock.addresse);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nom.hashCode();
        result = 31 * result + telephone.hashCode();
        result = 31 * result + (telephone1 != null ? telephone1.hashCode() : 0);
        result = 31 * result + addresse.hashCode();
        return result;
    }
}
