package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "uzytkownicy", schema = "dbo", catalog = "szpital")
public class UzytkownicyEntity {
    private int idUzytkownika;
    private String nazwa;
    private String hash;
    private String uprawnienia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUzytkownika")
    public int getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(int idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
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
    @Column(name = "hash")
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Basic
    @Column(name = "uprawnienia")
    public String getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(String uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UzytkownicyEntity that = (UzytkownicyEntity) o;
        return idUzytkownika == that.idUzytkownika &&
                Objects.equals(nazwa, that.nazwa) &&
                Objects.equals(hash, that.hash) &&
                Objects.equals(uprawnienia, that.uprawnienia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUzytkownika, nazwa, hash, uprawnienia);
    }
}
