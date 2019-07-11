package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 *  This is a class that represents an entity for each company.
 *
 * @author Angel Kukushev
 *
 */
@Entity
@Table(name = "company")
public class Company implements java.io.Serializable {

    // Properties

    private Integer idCompany;

    private String name;

    private Set<Employee> employees = new HashSet<Employee>(0);

    private Set<Building> buildings = new HashSet<Building>(0);

    //Getters with annotations

    /**
     * Get method for id.
     * @return idCompany This is a value representing the id of company.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idCompany", unique = true, nullable = false)
    public Integer getIdCompany() {
        return idCompany;
    }

    /**
     * Get method for name.
     * @return name This is a value representing the name of the company.
     */
    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    /**
     * Get method for employees.
     * @return employees This is a set representing all employees working in the company.
     */
    @OneToMany(mappedBy = "company")
    public Set<Employee> getEmployees() {
        return employees;
    }

    /**
     * Get method for buildings.
     * @return buildings This is a set representing all buildings covered by the company.
     */
    @OneToMany(mappedBy = "company")
    public Set<Building> getBuildings() {
        return buildings;
    }

     //Setters

    /**
     * Set method for id property.
     * @param idCompany This is an integer that is used in setting the id of the company.
     */
    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    /**
     * Set method for name property.
     * @param name  This is a variable that is used in setting the name of the company.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set method for employees.
     * @param employees  This is a set that is used in setting the employees of the company.
     */
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Set method for buildings.
     * @param buildings  This is a set that is used in setting the buildings of the company.
     */
    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }

    // Constructors

    /**
     * No parameter constructor.
     */
    public Company() {

    }

    /**
     * Constructor used in object creation.
     * @param name This is a string used to set the name of the company.
     */
    public Company(String name) {
        this.name = name;
    }

    // Additional

    /**
     * Method to add a Building object to the set of buildings for the company.
     * @param building This is an Building parameter passed and added to the set.
     */
    public void setSingleBuilding(Building building) {
        this.buildings.add(building);
    }

    /**
     *  Method that returns a string representation of the object when called.
     * @return name the name value of a building object.
     */
    @Override
    public String toString() {
        return name;
    }
}
//https://www.baeldung.com/hibernate-one-to-many