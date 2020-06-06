package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "oddzialy", schema = "dbo", catalog = "szpital")
public class OddzialyEntity {
    private int idOddzialu;
    private int idOrdynatora;
    private String nazwa;
    private String nrTelefonu;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOddzialu")
    public int getIdOddzialu() {
        return idOddzialu;
    }

    public void setIdOddzialu(int idOddzialu) {
        this.idOddzialu = idOddzialu;
    }

    @Basic
    @Column(name = "idOrdynatora")
    public int getIdOrdynatora() {
        return idOrdynatora;
    }

    public void setIdOrdynatora(int idOrdynatora) {
        this.idOrdynatora = idOrdynatora;
    }

    @Basic
    @Column(name = "nazwa")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "nrTelefonu")
    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OddzialyEntity that = (OddzialyEntity) o;
        return idOddzialu == that.idOddzialu &&
                idOrdynatora == that.idOrdynatora &&
                Objects.equals(nazwa, that.nazwa) &&
                Objects.equals(nrTelefonu, that.nrTelefonu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOddzialu, idOrdynatora, nazwa, nrTelefonu);
    }

    @Override
    public String toString() {
        return nazwa;

    }
}
