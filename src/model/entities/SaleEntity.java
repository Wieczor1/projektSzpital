package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sale", schema = "dbo", catalog = "szpital")
public class SaleEntity {
    private int idSali;
    private int idOddzialu;
    private int nrSali;
    private String typSali;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSali")
    public int getIdSali() {
        return idSali;
    }

    public void setIdSali(int idSali) {
        this.idSali = idSali;
    }

    @Basic
    @Column(name = "idOddzialu")
    public int getIdOddzialu() {
        return idOddzialu;
    }

    public void setIdOddzialu(int idOddzialu) {
        this.idOddzialu = idOddzialu;
    }

    @Basic
    @Column(name = "nrSali")
    public int getNrSali() {
        return nrSali;
    }

    public void setNrSali(int nrSali) {
        this.nrSali = nrSali;
    }

    @Basic
    @Column(name = "typSali")
    public String getTypSali() {
        return typSali;
    }

    public void setTypSali(String typSali) {
        this.typSali = typSali;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleEntity that = (SaleEntity) o;
        return idSali == that.idSali &&
                idOddzialu == that.idOddzialu &&
                nrSali == that.nrSali &&
                Objects.equals(typSali, that.typSali);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSali, idOddzialu, nrSali, typSali);
    }
}
