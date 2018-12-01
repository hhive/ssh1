package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Dlb {
    private int id;
    private String kl;
    private String xh;
    /** default constructor */
    public Dlb() {
    }

    /** minimal constructor */
    public Dlb(String xh) {
        this.xh = xh;
    }

    /** full constructor */
    public Dlb(String xh, String kl) {
        this.xh = xh;
        this.kl = kl;
    }

    public String getXh() {
        return this.xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "kl")
    public String getKl() {
        return kl;
    }

    public void setKl(String kl) {
        this.kl = kl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dlb dlb = (Dlb) o;
        return id == dlb.id &&
                Objects.equals(kl, dlb.kl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kl);
    }
}
