package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Kcb {
    private String kch;
    private String kcm;
    private Object kxxq;
    private Integer xs;
    private Integer xf;

    /** default constructor */
    public Kcb() {
    }

    /** minimal constructor */
    public Kcb(String kch) {
        this.kch = kch;
    }

    /** full constructor */
    public Kcb(String kch, String kcm, Short kxxq, Integer xs, Integer xf) {
        this.kch = kch;
        this.kcm = kcm;
        this.kxxq = kxxq;
        this.xs = xs;
        this.xf = xf;
    }

    @Id
    @Column(name = "kch")
    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch;
    }

    @Basic
    @Column(name = "kcm")
    public String getKcm() {
        return kcm;
    }

    public void setKcm(String kcm) {
        this.kcm = kcm;
    }

    @Basic
    @Column(name = "kxxq")
    public Object getKxxq() {
        return kxxq;
    }

    public void setKxxq(Object kxxq) {
        this.kxxq = kxxq;
    }

    @Basic
    @Column(name = "xs")
    public Integer getXs() {
        return xs;
    }

    public void setXs(Integer xs) {
        this.xs = xs;
    }

    @Basic
    @Column(name = "xf")
    public Integer getXf() {
        return xf;
    }

    public void setXf(Integer xf) {
        this.xf = xf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kcb kcb = (Kcb) o;
        return Objects.equals(kch, kcb.kch) &&
                Objects.equals(kcm, kcb.kcm) &&
                Objects.equals(kxxq, kcb.kxxq) &&
                Objects.equals(xs, kcb.xs) &&
                Objects.equals(xf, kcb.xf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kch, kcm, kxxq, xs, xf);
    }
}
