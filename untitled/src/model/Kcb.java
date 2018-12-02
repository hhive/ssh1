package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Kcb {
    private String kch;
    private String kcm;
    private int kxxq;
    private Integer xs;
    private Integer xf;
    private int weekBegin;
    private int weekEnd;
    private int weekDay;
    private int lesson;
    private String destination;
    private Zyb zyb;

    public Kcb() {
    }

    public Kcb(String kch, String kcm, int kxxq, Integer xs, Integer xf, int weekBegin, int weekEnd, int weekDay, int lesson, String destination, Zyb zyb) {
        this.kch = kch;
        this.kcm = kcm;
        this.kxxq = kxxq;
        this.xs = xs;
        this.xf = xf;
        this.weekBegin = weekBegin;
        this.weekEnd = weekEnd;
        this.weekDay = weekDay;
        this.lesson = lesson;
        this.destination = destination;
        this.zyb = zyb;
    }

    @Id
    @Column(name = "kch", nullable = false, length = 3)
    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch;
    }

    @Basic
    @Column(name = "kcm", nullable = true, length = 12)
    public String getKcm() {
        return kcm;
    }

    public void setKcm(String kcm) {
        this.kcm = kcm;
    }

    @Basic
    @Column(name = "kxxq", nullable = true)
    public int getKxxq() {
        return kxxq;
    }



    public void setKxxq(int kxxq) {
        this.kxxq = kxxq;
    }

    @Basic
    @Column(name = "xs", nullable = true)
    public Integer getXs() {
        return xs;
    }

    public void setXs(Integer xs) {
        this.xs = xs;
    }

    @Basic
    @Column(name = "xf", nullable = true)
    public Integer getXf() {
        return xf;
    }

    public void setXf(Integer xf) {
        this.xf = xf;
    }

    @Basic
    @Column(name = "weekBegin", nullable = false)
    public int getWeekBegin() {
        return weekBegin;
    }

    public void setWeekBegin(int weekBegin) {
        this.weekBegin = weekBegin;
    }

    @Basic
    @Column(name = "weekEnd", nullable = false)
    public int getWeekEnd() {
        return weekEnd;
    }

    public void setWeekEnd(int weekEnd) {
        this.weekEnd = weekEnd;
    }

    @Basic
    @Column(name = "weekDay", nullable = false)
    public int getWeekDay() {
        return weekDay;
    }



    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    @Basic
    @Column(name = "lesson", nullable = false)
    public int getLesson() {
        return lesson;
    }


    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    @Basic
    @Column(name = "destination", nullable = false, length = 255)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kcb kcb = (Kcb) o;
        return weekBegin == kcb.weekBegin &&
                weekEnd == kcb.weekEnd &&
                Objects.equals(kch, kcb.kch) &&
                Objects.equals(kcm, kcb.kcm) &&
                Objects.equals(kxxq, kcb.kxxq) &&
                Objects.equals(xs, kcb.xs) &&
                Objects.equals(xf, kcb.xf) &&
                Objects.equals(weekDay, kcb.weekDay) &&
                Objects.equals(lesson, kcb.lesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kch, kcm, kxxq, xs, xf, weekBegin, weekEnd, weekDay, lesson);
    }

    @ManyToOne
    @JoinColumn(name = "zy_id")//外键
    public Zyb getZyb(){
        return this.zyb;
    }

    public void setZyb(Zyb zyb){
        this.zyb = zyb;
    }
}
