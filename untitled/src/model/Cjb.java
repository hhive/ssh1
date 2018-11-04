package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CjbPK.class)
public class Cjb {
    private String xh;
    private String kch;
    private Integer cj;
    private Integer xf;

    @Id
    @Column(name = "xh")
    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
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
