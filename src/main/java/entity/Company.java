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

    private Set<Building> buildings = new HashSet<Building>(0);

    /*
     *
     * Getters with annotations
     *
     */

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idCompany", unique = true, nullable = false)
    public Integer getIdCompany() {
        return idCompany;
    }

    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "company")
    public Set<Employee> getEmployees() {
        return employees;
    }

    @OneToMany(mappedBy = "company")
    public Set<Building> getBuildings() {
        return buildings;
    }

    /*
     *
     * Setters
     *
     */

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }

    /*
     *
     * Constructors
     *
     */

    public Company() {

    }

    public Company(String name) {
        this.name = name;
    }

    /*
     *
     *  Additional
     *
     */

    public void setSingleBuilding(Building building) {
        this.buildings.add(building);
    }

    @Override
    public String toString() {
        return name;
    }
}
//https://www.baeldung.com/hibernate-one-to-many