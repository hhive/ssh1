package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CjbId implements Serializable {
    private String xh;
    private String kch;

    // Constructors

    /** default constructor */
    public CjbId() {
    }

    /** full constructor */
    public CjbId(String xh, String kch) {
        this.xh = xh;
        this.kch = kch;
    }

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
        CjbId cjbId = (CjbId) o;
        return Objects.equals(xh, cjbId.xh) &&
                Objects.equals(kch, cjbId.kch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xh, kch);
    }
}
