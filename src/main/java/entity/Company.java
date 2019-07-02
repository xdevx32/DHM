package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "company")
public class Company implements java.io.Serializable {

    /*
     *
     *  Properties
     *
     */

    private Integer idCompany;

    private String name;

    private Set<Employee> employees = new HashSet<Employee>(0);

    /*
     *
     * Getters with annotations
     *
     */

    public Company() {

    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idCompany", unique = true, nullable = false)
    public Integer getIdCompany() {
        return idCompany;
    }

    /*
     *
     * Setters
     *
     */

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     *
     * Constructors
     *
     */

    @OneToMany(mappedBy = "company")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    /*
     *
     *  Additional
     *
     */

    @Override
    public String toString() {
        return name;
    }
}
//https://www.baeldung.com/hibernate-one-to-many