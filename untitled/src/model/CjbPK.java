package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CjbPK implements Serializable {
    private String xh;
    private String kch;

    @Column(name = "xh")
    @Id
    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    @Column(name = "kch")
    @Id
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
        CjbPK cjbPK = (CjbPK) o;
        return Objects.equals(xh, cjbPK.xh) &&
                Objects.equals(kch, cjbPK.kch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xh, kch);
    }
}
