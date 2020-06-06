package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lekarze", schema = "dbo", catalog = "szpital")
public class LekarzeEntity {
    private int idLekarza;
    private int idAdresu;
    private String imie;
    private String nazwisko;
    private String specjalizacja;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLekarza")
    public int getIdLekarza() {
        return idLekarza;
    }

    public void setIdLekarza(int idLekarza) {
        this.idLekarza = idLekarza;
    }

    @Basic
    @Column(name = "idAdresu")
    public int getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(int idAdresu) {
        this.idAdresu = idAdresu;
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
    @Column(name = "specjalizacja")
    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LekarzeEntity that = (LekarzeEntity) o;
        return idLekarza == that.idLekarza &&
                idAdresu == that.idAdresu &&
                Objects.equals(imie, that.imie) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(specjalizacja, that.specjalizacja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLekarza, idAdresu, imie, nazwisko, specjalizacja);
    }

    @Override
    public String toString() {
        return imie  + " "+ nazwisko + ", " + specjalizacja;
    }
}
