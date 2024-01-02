package sn.optimizer.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="utilisateurs", uniqueConstraints={
        @UniqueConstraint(name="UQ_UTILISATEURS_USERNAME", columnNames={"username"}),
        @UniqueConstraint(name="UQ_UTILISATEURS_TELEPHONE", columnNames={"telephone"})
})
public class Utilisateur {

    @Id
    @SequenceGenerator(name="utilisateurs_id_sequence",
            sequenceName="utilisateurs_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="utilisateurs_id_sequence")
    private Long id;

    @Column(name="nom_complet", columnDefinition="varchar not null")
    private String nomComplet;

    @Column(name="username", columnDefinition="varchar(150) not null")
    private String username;

    @Column(name="password", columnDefinition="varchar(50) not null")
    private String password;

    @Column(name="role", columnDefinition="varchar(20) not null")
    private String role;

    @Column(name="telephone", columnDefinition = "varchar(50) not null")
    private String telephone;

    @Column(name="addresse")
    private String addresse;

    public Utilisateur() {}

    public Utilisateur(Long id, String nomComplet,
                       String username, String password,
                       String role, String telephone,
                       String addresse) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.username = username;
        this.password = password;
        this.role = role;
        this.telephone = telephone;
        this.addresse = addresse;
    }

    public Utilisateur(String nomComplet, String username,
                       String password, String role,
                       String telephone, String addresse) {
        this.nomComplet = nomComplet;
        this.username = username;
        this.password = password;
        this.role = role;
        this.telephone = telephone;
        this.addresse = addresse;
    }

    public Long getId() {
        return id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(nomComplet, that.nomComplet)
                && Objects.equals(username, that.username) && Objects.equals(password, that.password)
                && Objects.equals(role, that.role) && Objects.equals(telephone, that.telephone)
                && Objects.equals(addresse, that.addresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomComplet, username, password, role, telephone, addresse);
    }
}
