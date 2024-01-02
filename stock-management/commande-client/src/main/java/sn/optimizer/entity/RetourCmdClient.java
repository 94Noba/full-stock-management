package sn.optimizer.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="retours_cmd_client")
public class RetourCmdClient {

    @Id
    @SequenceGenerator(name="retour_cmd_client_id_sequence",
            sequenceName="retour_cmd_client_id_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="retour_cmd_client_id_sequence")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="date_retour", nullable=false)
    private LocalDate dateRetour;

    @Column(name="valeur_cmd_avant_retour", nullable=false)
    private float valeurCmdAvantRetour;

    public RetourCmdClient() {}

    public RetourCmdClient(Long id, LocalDate dateRetour, float valeurCmdAvantRetour) {
        this.id = id;
        this.dateRetour = dateRetour;
        this.valeurCmdAvantRetour = valeurCmdAvantRetour;
    }

    public RetourCmdClient(LocalDate dateRetour, float valeurCmdAvantRetour) {
        this.dateRetour = dateRetour;
        this.valeurCmdAvantRetour = valeurCmdAvantRetour;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public float getValeurCmdAvantRetour() {
        return valeurCmdAvantRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void setValeurCmdAvantRetour(float valeurCmdAvantRetour) {
        this.valeurCmdAvantRetour = valeurCmdAvantRetour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RetourCmdClient that)) return false;
        return Float.compare(valeurCmdAvantRetour, that.valeurCmdAvantRetour) == 0
                && Objects.equals(id, that.id) && Objects.equals(dateRetour, that.dateRetour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateRetour, valeurCmdAvantRetour);
    }
}
