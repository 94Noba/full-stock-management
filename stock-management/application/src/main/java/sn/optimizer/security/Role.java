package sn.optimizer.security;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="roles", uniqueConstraints={
        @UniqueConstraint(name="UQ_ROLES_LIBELLE", columnNames={"libelle"})
})
public class Role {

    @Id
    @SequenceGenerator(name="roles_id_sequence",
            sequenceName="roles_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roles_id_sequence")
    private Long id;

    @Column(name="libelle", columnDefinition="varchar(50) not null")
    private String libelle;

    public Role() {}

    public Role(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Role(String libelle) {
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
        if (!(o instanceof Role role)) return false;
        return Objects.equals(id, role.id) && Objects.equals(libelle, role.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
    }
}
