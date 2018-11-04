package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CjbPK.class)
public class Cjb {

    
    public CjbPK getId() {
        return id;
    }

    public void setId(CjbPK id) {
        this.id = id;
    }

    private CjbPK id;
    private Integer cj;
    private Integer xf;
//    private String xh;
//    private String kch;

    /** default constructor */
    public Cjb() {
    }

    /** minimal constructor */
    public Cjb(CjbPK id) {
        this.id = id;
    }

    /** full constructor */
    public Cjb(CjbPK id, Integer cj, Integer xf) {
        this.id = id;
        this.cj = cj;
        this.xf = xf;
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
        return Objects.equals(cj, cjb.cj) &&
                Objects.equals(xf, cjb.xf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cj, xf);
    }

//    @Id
//    @Column(name = "xh")
//    public String getXh() {
//        return xh;
//    }
//
//    public void setXh(String xh) {
//        this.xh = xh;
//    }
//
//    @Id
//    @Column(name = "kch")
//    public String getKch() {
//        return kch;
//    }
//
//    public void setKch(String kch) {
//        this.kch = kch;
//    }
}
