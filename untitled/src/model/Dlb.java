package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Dlb {
    private String id;
    private String password;
    private String name;
    private String role;
    private String age;
    private int sex;

    public Dlb() {
    }

    public Dlb(String  id, String password, String name, String role, String age, int sex) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
        this.age = age;
        this.sex = sex;
    }

    @Id
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 255)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "age", nullable = true, length = 20)
    public String getAge() {
        return age;
    }


    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dlb dlb = (Dlb) o;
        return id == dlb.id &&
                Objects.equals(password, dlb.password) &&
                Objects.equals(name, dlb.name) &&
                Objects.equals(role, dlb.role) &&
                Objects.equals(age, dlb.age) &&
                Objects.equals(sex, dlb.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, name, role, age, sex);
    }
}
