package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "leki", schema = "dbo", catalog = "szpital")
public class LekiEntity {
    private int idLeku;
    private String nazwaLeku;
    private String kodLeku;
    private boolean refundacja;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLeku")
    public int getIdLeku() {
        return idLeku;
    }

    public void setIdLeku(int idLeku) {
        this.idLeku = idLeku;
    }

    @Basic
    @Column(name = "nazwaLeku")
    public String getNazwaLeku() {
        return nazwaLeku;
    }

    public void setNazwaLeku(String nazwaLeku) {
        this.nazwaLeku = nazwaLeku;
    }

    @Basic
    @Column(name = "kodLeku")
    public String getKodLeku() {
        return kodLeku;
    }

    public void setKodLeku(String kodLeku) {
        this.kodLeku = kodLeku;
    }

    @Basic
    @Column(name = "refundacja")
    public boolean isRefundacja() {
        return refundacja;
    }

    public void setRefundacja(boolean refundacja) {
        this.refundacja = refundacja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LekiEntity that = (LekiEntity) o;
        return idLeku == that.idLeku &&
                refundacja == that.refundacja &&
                Objects.equals(nazwaLeku, that.nazwaLeku) &&
                Objects.equals(kodLeku, that.kodLeku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLeku, nazwaLeku, kodLeku, refundacja);
    }

    @Override
    public String toString() {
        return nazwaLeku;

    }
}
