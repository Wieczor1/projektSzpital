package model.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pacjenci", schema = "dbo", catalog = "szpital")
public class PacjenciEntity {
    private int idPacjenta;
    private String imie;
    private String nazwisko;
    private Date dataPrzyjecia;
    private double masaCiala;
    private double wzrost;
    private Integer idDiagnozy;
    private Integer idLeczenia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPacjenta")
    public int getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(int idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    @Basic
    @Column(name = "imie")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "dataPrzyjecia")
    public Date getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(Date dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    @Basic
    @Column(name = "masaCiala")
    public double getMasaCiala() {
        return masaCiala;
    }

    public void setMasaCiala(double masaCiala) {
        this.masaCiala = masaCiala;
    }

    @Basic
    @Column(name = "wzrost")
    public double getWzrost() {
        return wzrost;
    }

    public void setWzrost(double wzrost) {
        this.wzrost = wzrost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacjenciEntity that = (PacjenciEntity) o;
        return idPacjenta == that.idPacjenta &&
                Double.compare(that.masaCiala, masaCiala) == 0 &&
                Double.compare(that.wzrost, wzrost) == 0 &&
                Objects.equals(imie, that.imie) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(dataPrzyjecia, that.dataPrzyjecia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPacjenta, imie, nazwisko, dataPrzyjecia, masaCiala, wzrost);
    }

    @Basic
    @Column(name = "idDiagnozy")
    public Integer getIdDiagnozy() {
        return idDiagnozy;
    }

    public void setIdDiagnozy(Integer idDiagnozy) {
        this.idDiagnozy = idDiagnozy;
    }

    @Basic
    @Column(name = "idLeczenia")
    public Integer getIdLeczenia() {
        return idLeczenia;
    }

    public void setIdLeczenia(Integer idLeczenia) {
        this.idLeczenia = idLeczenia;
    }
}
