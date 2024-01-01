package sn.optimizer.fournisseur.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="founisseurs", uniqueConstraints = {
        @UniqueConstraint(name = "UQ_FOURNISSEURS_TELEPHONE", columnNames = {"telephone"}),
        @UniqueConstraint(name = "UQ_FOURNISSEURS_EMAIL", columnNames = {"email"})
})
public class Fournisseur {

    @Id
    @SequenceGenerator(name="fournisseurs_id_sequence",
            sequenceName="fournisseurs_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fournisseurs_id_sequence")
    private Long id;

    @Column(name = "entreprise", columnDefinition = "varchar not null")
    private String entreprise;

    @Column(name = "telephone", columnDefinition = "varchar(50) not null")
    private String telephone;

    @Column(name="telephone1", columnDefinition = "varchar(50)")
    private String telephone1;

    @Column(name="email", columnDefinition = "varchar not null")
    private String email;

    @Column(name = "fax", columnDefinition = "varchar")
    private String fax;

    @Column(name = "addresse", columnDefinition = "varchar")
    private String addresse;

    public Fournisseur(){}

    public Fournisseur(Long id, String entreprise,
                       String telephone, String telephone1,
                       String email, String fax,
                       String addresse) {
        this.id = id;
        this.entreprise = entreprise;
        this.telephone = telephone;
        this.telephone1 = telephone1;
        this.email = email;
        this.fax = fax;
        this.addresse = addresse;
    }

    public Fournisseur(String entreprise, String telephone,
                       String telephone1, String email,
                       String fax, String addresse) {
        this.entreprise = entreprise;
        this.telephone = telephone;
        this.telephone1 = telephone1;
        this.email = email;
        this.fax = fax;
        this.addresse = addresse;
    }

    public Long getId() {
        return id;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fournisseur)) return false;

        Fournisseur that = (Fournisseur) o;

        if (!id.equals(that.id)) return false;
        if (!entreprise.equals(that.entreprise)) return false;
        if (!telephone.equals(that.telephone)) return false;
        if (!Objects.equals(telephone1, that.telephone1)) return false;
        if (!email.equals(that.email)) return false;
        if (!Objects.equals(fax, that.fax)) return false;
        return Objects.equals(addresse, that.addresse);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + entreprise.hashCode();
        result = 31 * result + telephone.hashCode();
        result = 31 * result + (telephone1 != null ? telephone1.hashCode() : 0);
        result = 31 * result + email.hashCode();
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (addresse != null ? addresse.hashCode() : 0);
        return result;
    }
}
