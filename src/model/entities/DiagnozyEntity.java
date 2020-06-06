package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "diagnozy", schema = "dbo", catalog = "szpital")
public class DiagnozyEntity {
    private int idDiagnozy;
    private String kodDiagnozy;
    private String opis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDiagnozy")
    public int getIdDiagnozy() {
        return idDiagnozy;
    }

    public void setIdDiagnozy(int idDiagnozy) {
        this.idDiagnozy = idDiagnozy;
    }

    @Basic
    @Column(name = "kodDiagnozy")
    public String getKodDiagnozy() {
        return kodDiagnozy;
    }

    public void setKodDiagnozy(String kodDiagnozy) {
        this.kodDiagnozy = kodDiagnozy;
    }

    @Basic
    @Column(name = "opis")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnozyEntity that = (DiagnozyEntity) o;
        return idDiagnozy == that.idDiagnozy &&
                Objects.equals(kodDiagnozy, that.kodDiagnozy) &&
                Objects.equals(opis, that.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiagnozy, kodDiagnozy, opis);
    }

    @Override
    public String toString() {
        return opis;
    }
}
