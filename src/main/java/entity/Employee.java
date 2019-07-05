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

    private Set<Building> buildingsThatTheEmployeeMaintains = new HashSet<Building>(0);

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

    @Transient
    public Set<Building> getBuildingsThatTheEmployeeMaintains() {
        return buildingsThatTheEmployeeMaintains;
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

    public void setBuildingsThatTheEmployeeMaintains(Set<Building> buildingsThatTheEmployeeMaintains) {
        this.buildingsThatTheEmployeeMaintains = buildingsThatTheEmployeeMaintains;
    }

    /*
     *
     * Constructors
     *
     */

    public Employee() {

    }

    public Employee(String name, String egn, Company company) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.egn = egn;
        this.company = company;
    }

    /*
     *
     *  Additional
     *
     */

    public void setSingleBuilding(Building building) {
        this.buildingsThatTheEmployeeMaintains.add(building);
    }

    @Override
    public String toString() {
        return name;
    }
}