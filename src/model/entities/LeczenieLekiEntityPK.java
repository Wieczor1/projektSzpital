package model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LeczenieLekiEntityPK implements Serializable {
    private int idLeku;
    private int idLeczenia;

    @Column(name = "idLeku")
    @Id
    public int getIdLeku() {
        return idLeku;
    }

    public void setIdLeku(int idLeku) {
        this.idLeku = idLeku;
    }

    @Column(name = "idLeczenia")
    @Id
    public int getIdLeczenia() {
        return idLeczenia;
    }

    public void setIdLeczenia(int idLeczenia) {
        this.idLeczenia = idLeczenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeczenieLekiEntityPK that = (LeczenieLekiEntityPK) o;
        return idLeku == that.idLeku &&
                idLeczenia == that.idLeczenia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLeku, idLeczenia);
    }
}
