package entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "employee")
public class Employee implements java.io.Serializable {

    /*
     *
     * Properties
     *
     */

    private Integer idEmployee;

    private String name;

    private String egn;

    private Company company;

    private Set<Building> buildings = new HashSet<Building>(0);

    /*
     *
     * Getters with annotations
     *
     */

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idEmployee", unique = true, nullable = false)
    public Integer getIdEmployee() {
        return idEmployee;
    }

    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    @Column(name = "egn", length = 10)
    public String getEgn() {
        return egn;
    }

    @ManyToOne
    @JoinColumn(name = "idCompany", nullable = true)
    public Company getCompany() {
        return company;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_building", joinColumns = {@JoinColumn(name = "idEmployee")}, inverseJoinColumns = {@JoinColumn(name = "idBuilding")})
    public Set<Building> getBuildings() {
        return buildings;
    }

    /*
     *
     * Setters
     *
     */

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }

    /*
     *
     * Constructors
     *
     */

    public Employee() {

    }

    public Employee(String name, String egn, Company company, Building building) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.egn = egn;
        this.company = company;
        this.buildings.add(building);
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