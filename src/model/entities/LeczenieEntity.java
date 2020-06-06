package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "leczenie", schema = "dbo", catalog = "szpital")
public class LeczenieEntity {
    private int idLeczenia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLeczenia")
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
        LeczenieEntity that = (LeczenieEntity) o;
        return idLeczenia == that.idLeczenia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLeczenia);
    }
}
