package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Zyb {
    private int id;
    private String zym;
    private Integer rs;
    private String fdy;

    /** default constructor */
    public Zyb() {
    }

    /** minimal constructor */
    public Zyb(String zym) {
        this.zym = zym;
    }

    /** full constructor */
    public Zyb(String zym, Integer rs, String fdy) {
        this.zym = zym;
        this.rs = rs;
        this.fdy = fdy;
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
    @Column(name = "zym")
    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    @Basic
    @Column(name = "rs")
    public Integer getRs() {
        return rs;
    }

    public void setRs(Integer rs) {
        this.rs = rs;
    }

    @Basic
    @Column(name = "fdy")
    public String getFdy() {
        return fdy;
    }

    public void setFdy(String fdy) {
        this.fdy = fdy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zyb zyb = (Zyb) o;
        return id == zyb.id &&
                Objects.equals(zym, zyb.zym) &&
                Objects.equals(rs, zyb.rs) &&
                Objects.equals(fdy, zyb.fdy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zym, rs, fdy);
    }
}
