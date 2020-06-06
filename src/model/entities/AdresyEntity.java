package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adresy", schema = "dbo", catalog = "szpital")
public class AdresyEntity {
    private int idAdresu;
    private String miasto;
    private String kodPocztowy;
    private String ulica;
    private int numerDomu;
    private int numerLokalu;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TODO lapanie wyjatku suuwania klucza obcego
    @Column(name = "idAdresu")
    public int getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(int idAdresu) {
        this.idAdresu = idAdresu;
    }

    @Basic
    @Column(name = "miasto")
    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Basic
    @Column(name = "kodPocztowy")
    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Basic
    @Column(name = "ulica")
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Basic
    @Column(name = "numerDomu")
    public int getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(int numerDomu) {
        this.numerDomu = numerDomu;
    }

    @Basic
    @Column(name = "numerLokalu")
    public int getNumerLokalu() {
        return numerLokalu;
    }

    public void setNumerLokalu(int numerLokalu) {
        this.numerLokalu = numerLokalu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresyEntity that = (AdresyEntity) o;
        return idAdresu == that.idAdresu &&
                numerDomu == that.numerDomu &&
                numerLokalu == that.numerLokalu &&
                Objects.equals(miasto, that.miasto) &&
                Objects.equals(kodPocztowy, that.kodPocztowy) &&
                Objects.equals(ulica, that.ulica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdresu, miasto, kodPocztowy, ulica, numerDomu, numerLokalu);
    }

    @Override
    public String toString() {
        return ulica + " " + numerDomu + "/" + numerLokalu + ", " + kodPocztowy + " " + miasto;
    }
}
