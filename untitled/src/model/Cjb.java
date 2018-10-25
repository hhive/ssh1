package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cjb {
    private CjbId id;
    private String xh;
    private String kch;
    private Integer cj;
    private Integer xf;

    /** default constructor */
    public Cjb() {
    }

    /** minimal constructor */
    public Cjb(CjbId id) {
        this.id = id;
    }

    /** full constructor */
    public Cjb(CjbId id, Integer cj, Integer xf) {
        this.id = id;
        this.cj = cj;
        this.xf = xf;
    }
    @Id
    @Column(name = "xh")
    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    @Basic
    @Column(name = "kch")
    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch;
    }

    @Basic
    @Column(name = "cj")
    public Integer getCj() {
        return cj;
    }

    public void setCj(Integer cj) {
        this.cj = cj;
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
        Cjb cjb = (Cjb) o;
        return Objects.equals(xh, cjb.xh) &&
                Objects.equals(kch, cjb.kch) &&
                Objects.equals(cj, cjb.cj) &&
                Objects.equals(xf, cjb.xf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xh, kch, cj, xf);
    }
}
