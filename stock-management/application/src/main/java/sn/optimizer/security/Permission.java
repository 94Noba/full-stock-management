package sn.optimizer.security;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="permissions", uniqueConstraints={
        @UniqueConstraint(name="UQ_PERMISSIONS_ACCESS", columnNames={"access"})
})
public class Permission {

    @Id
    @SequenceGenerator(name="permissions_id_Sequence",
            sequenceName="permissions_id_Sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="permissions_id_Sequence")
    private Long id;

    @Column(name="access", length=50, nullable=false)
    private String access;

    public Permission() {}

    public Permission(Long id, String access) {
        this.id = id;
        this.access = access;
    }

    public Permission(String access) {
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(access, that.access);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, access);
    }
}
