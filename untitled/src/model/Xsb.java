package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Xsb {
    private String xh;
    private String xm;
    private Object xb;
    private String cssj;
    private Integer zxf;
    private String bz;
    private byte[] zp;
    private Zyb zyb;//

    /** default constructor */
    public Xsb() {
    }

    /** minimal constructor */
    public Xsb(String xh, String xm, Short xb) {//
        this.xh = xh;
        this.xm = xm;
        this.xb = xb;
        //this.zyId = zyId;
    }

    /** full constructor */
    public Xsb(String xh, String xm, Short xb, String cssj,//
               Integer zxf, String bz, byte[] zp, Zyb zyb) {//
        this.xh = xh;
        this.xm = xm;
        this.xb = xb;
        this.cssj = cssj;
        //this.zyId = zyId;
        this.zxf = zxf;
        this.bz = bz;
        this.zp = zp;
        this.zyb = zyb;//
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
    @Column(name = "xm")
    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    @Basic
    @Column(name = "xb")
    public Object getXb() {
        return xb;
    }

    public void setXb(Object xb) {
        this.xb = xb;
    }

    @Basic
    @Column(name = "cssj")
    public String getCssj() {
        return cssj;
    }

    public void setCssj(String cssj) {
        this.cssj = cssj;
    }

    @Basic
    @Column(name = "zxf")
    public Integer getZxf() {
        return zxf;
    }

    public void setZxf(Integer zxf) {
        this.zxf = zxf;
    }

    @Basic
    @Column(name = "bz")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "zp")
    public byte[] getZp() {
        return zp;
    }

    public void setZp(byte[] zp) {
        this.zp = zp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xsb xsb = (Xsb) o;
        return Objects.equals(xh, xsb.xh) &&
                Objects.equals(xm, xsb.xm) &&
                Objects.equals(xb, xsb.xb) &&
                Objects.equals(cssj, xsb.cssj) &&
                Objects.equals(zxf, xsb.zxf) &&
                Objects.equals(bz, xsb.bz) &&
                Arrays.equals(zp, xsb.zp);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(xh, xm, xb, cssj, zxf, bz);
        result = 31 * result + Arrays.hashCode(zp);
        return result;
    }

//    public Zyb getZyb(){
//        return this.zyb;
//    }
//
//    public void setZyb(Zyb zyb){
//        this.zyb = zyb;
//    }
}
