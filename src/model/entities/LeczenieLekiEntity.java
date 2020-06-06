package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "leczenie_leki", schema = "dbo", catalog = "szpital")
@IdClass(LeczenieLekiEntityPK.class)
public class LeczenieLekiEntity {
    private int idLeku;
    private int idLeczenia;
    private double dawkowanieMiligramy;
    private String uwagi;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLeku")
    public int getIdLeku() {
        return idLeku;
    }

    public void setIdLeku(int idLeku) {
        this.idLeku = idLeku;
    }

    @Id
    @Column(name = "idLeczenia")
    public int getIdLeczenia() {
        return idLeczenia;
    }

    public void setIdLeczenia(int idLeczenia) {
        this.idLeczenia = idLeczenia;
    }

    @Basic
    @Column(name = "dawkowanieMiligramy")
    public double getDawkowanieMiligramy() {
        return dawkowanieMiligramy;
    }

    public void setDawkowanieMiligramy(double dawkowanieMiligramy) {
        this.dawkowanieMiligramy = dawkowanieMiligramy;
    }

    @Basic
    @Column(name = "uwagi")
    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeczenieLekiEntity that = (LeczenieLekiEntity) o;
        return idLeku == that.idLeku &&
                idLeczenia == that.idLeczenia &&
                Double.compare(that.dawkowanieMiligramy, dawkowanieMiligramy) == 0 &&
                Objects.equals(uwagi, that.uwagi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLeku, idLeczenia, dawkowanieMiligramy, uwagi);
    }
}
