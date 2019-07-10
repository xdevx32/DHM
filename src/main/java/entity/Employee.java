package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "employee")
public class Employee implements java.io.Serializable {

    // Properties

    private Integer idEmployee;

    private String name;

    private String egn;

    private Company company;

    private Set<Building> buildings = new HashSet<Building>(0);


    // Getters with annotations

    /**
     * Get method for id.
     * @return idEmployee This is a value representing the id of employee.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idEmployee", unique = true, nullable = false)
    public Integer getIdEmployee() {
        return idEmployee;
    }

    /**
     * Get method for name.
     * @return name This is a value representing the name of the employee.
     */
    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    /**
     * Get method for egn.
     * @return egn This is a value representing the egn of the employee.
     */
    @Column(name = "egn", length = 10)
    public String getEgn() {
        return egn;
    }

    /**
     * Get method for company.
     * @return company This is a value representing the company that the employee works in.
     */
    @ManyToOne
    @JoinColumn(name = "idCompany", nullable = true)
    public Company getCompany() {
        return company;
    }

    /**
     * Get method for buildings.
     * @return buildings This is a set representing all buildings maintained by the employee.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_building", joinColumns = {@JoinColumn(name = "idEmployee")}, inverseJoinColumns = {@JoinColumn(name = "idBuilding")})
    public Set<Building> getBuildings() {
        return buildings;
    }

    // Setters

    /**
     * Set method for id property.
     * @param idEmployee This is an integer that is used in setting the id of the employee.
     */
    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    /**
     * Set method for name property.
     * @param name  This is a variable that is used in setting the name of the employee.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set method for egn property.
     * @param egn  This is a variable that is used in setting the egn of the employee.
     */
    public void setEgn(String egn) {
        this.egn = egn;
    }

    /**
     * Set method for company.
     * @param company This is a Company object that is used in setting the company the employee works in.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     *  Set method for buildings.
     * @param buildings This is a set holding all buildings that the employee maintains.
     */
    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }

    // Constructors

    /**
     * No parameter constructor.
     */
    public Employee() {

    }

    /**
     * Constructor used in object creation.
     * @param name This is a string used to set the name of the building.
     * @param egn This is a string used to set the address of the building.
     * @param company This is an integer used to set the floors of the building.
     * @param building This is an integer used to set the apartment count of the building.
     */
    public Employee(String name, String egn, Company company, Building building) {
        this.name = name;
        this.egn = egn;
        this.company = company;
        this.buildings.add(building);
    }

    // Additional

    /**
     * Method to add a building object to the set of buildings that the employee maintains.
     * @param building This is a Building parameter passed and added to the set.
     */
    public void setSingleBuilding(Building building) {
        this.buildings.add(building);
    }

    /**
     *  Method that returns a string representation of the object when called.
     * @return name The value of the name property of the employee object.
     */
    @Override
    public String toString() {
        return name;
    }
}