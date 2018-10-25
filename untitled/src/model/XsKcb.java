package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "xs_kcb", schema = "xscjgl", catalog = "")
@IdClass(CjbId.class)
public class XsKcb {
    private String xh;
    private String kch;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XsKcb xsKcb = (XsKcb) o;
        return Objects.equals(xh, xsKcb.xh) &&
                Objects.equals(kch, xsKcb.kch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xh, kch);
    }
}
