package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 *  This is a class that represents an entity for each building.
 *
 * @author Angel Kukushev
 *
 */
@Entity
@Table(name = "building")
public class Building implements java.io.Serializable{

    // Properties

    private Integer idBuilding;

    private String name;

    private String address;

    private Integer floors;

    private Integer apartmentsCount;

    private Double area;

    private Integer sharedParts;

    private Set<ApartmentOwner> apartmentOwners = new HashSet<ApartmentOwner>(0);

    private Set<Employee> employees = new HashSet<Employee>(0);

    private Company company;

    private Double tax;

    private Boolean hasService;

    //  Getters with annotations

    /**
     * Get method for id.
     * @return idBuilding This is a value representing the id of building.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idBuilding", unique = true, nullable = false)
    public Integer getIdBuilding() {
        return idBuilding;
    }

    /**
     * Get method for name.
     * @return name This is a value representing the name of the building.
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * Get method for address.
     * @return address This is a value representing the address of the building.
     */
    @Column(name = "address", length = 40)
    public String getAddress() {
        return address;
    }

    /**
     * Get method for floors.
     * @return floors  This is a value representing the number of floors in a building.
     */
    @Column(name = "floors")
    public Integer getFloors() {
        return floors;
    }

    /**
     * Get method for apartment count.
     * @return apartmentsCount This is a value representing the number of apartments in a building.
     */
    @Column(name = "apartments_count")
    public Integer getApartmentsCount() {
        return apartmentsCount;
    }

    /**
     * Get method for area.
     * @return area This is a value representing the area of the building.
     */
    @Column(name = "area")
    public Double getArea() {
        return area;
    }

    /**
     * Get method for shared parts.
     * @return sharedParts This is a value representing the shared parts of the building.
     */
    @Column(name = "shared_parts")
    public Integer getSharedParts() {
        return sharedParts;
    }

    /**
     * Get method for apartment owners in the building.
     * @return apartmentOwners This is a set representing all apartment owners living in a building.
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBuilding", nullable = true)
    public Set<ApartmentOwner> getApartmentOwners() {
        return apartmentOwners;
    }

    /**
     * Get method for employees.
     * @return employees This is a set representing all employees maintaining the building.
     */
    @Transient
    public Set<Employee> getEmployees() {
        return employees;
    }

    /**
     * Get method for company.
     * @return company This is a Company object holding the company of the building.
     */
    @ManyToOne
    public Company getCompany() {
        return company;
    }

    /**
     * Get method for tax.
     * @return tax This a numeric value representing the monthly tax for the building.
     */
    @Column(name = "tax")
    public Double getTax() {
        return tax;
    }

    /**
     * Get method for hasService.
     * @return hasService This is boolean variable that represents the state of having
     * an employee of a company that maintains the service.
     */
    @Column(name = "has_service")
    public Boolean getHasService() {
        return hasService;
    }

     //Setters

    /**
     * Set method for id property.
     * @param idBuilding This is an integer that is used in setting the id of the building.
     */
    public void setIdBuilding(Integer idBuilding) {
        this.idBuilding = idBuilding;
    }

    /**
     * Set method for name property.
     * @param name  This is a variable that is used in setting the name of the building.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set method for address property.
     * @param address  This is a variable that is used in setting the address of the building.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set method for apartment owners.
     * @param apartmentOwners  This is a set that is used in setting the apartment owners of the building.
     */
    public void setApartmentOwners(Set<ApartmentOwner> apartmentOwners) {
        this.apartmentOwners = apartmentOwners;
    }

    /**
     * Set method for floors property.
     * @param floors  This is an Integer variable that is used in setting the floors of the building.
     */
    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    /**
     * Set method for apartment count.
     * @param apartmentsCount  This is an Integer variable that is used in setting the number of apartments of the building.
     */
    public void setApartmentsCount(Integer apartmentsCount) {
        this.apartmentsCount = apartmentsCount;
    }

    /**
     * Set method for area.
     * @param area  This is a numeric variable that is used in setting the area of the building.
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * Set method for shared parts.
     * @param sharedParts  This is an Integer variable that is used in setting the number of shared parts of the building.
     */
    public void setSharedParts(Integer sharedParts) {
        this.sharedParts = sharedParts;
    }

    /**
     * Set method for employees.
     * @param employees  This is a set that is used in setting the employees of the building.
     */
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Set method for company.
     * @param company  This is a Company object that is used in setting the company of the building.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Set method for tax.
     * @param tax  This is numeric value that is used in setting tax of the building.
     */
    public void setTax(Double tax) {
        this.tax = tax;
    }

    /**
     * Set method for hasService.
     * @param hasService  This is a boolean variable that is used in setting the value of hasService .
     */
    public void setHasService(Boolean hasService) {
        this.hasService = hasService;
    }

    // Constructors

    /**
     * No parameter constructor.
     */
    public Building() {

    }

    /**
     * Constructor used in object creation.
     * @param name This is a string used to set the name of the building.
     * @param address This is a string used to set the address of the building.
     * @param floors This is an integer used to set the floors of the building.
     * @param apartmentsCount This is an integer used to set the apartment count of the building.
     * @param area This is a double used to set the area of the building.
     * @param sharedParts This is an integer used to set the shared parts of a building.
     *
     */
    public Building(String name, String address, Integer floors, Integer apartmentsCount, Double area, Integer sharedParts) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.apartmentsCount = apartmentsCount;
        this.area = area;
        this.sharedParts = sharedParts;
        this.hasService = false;
    }

    // Additional

    /**
     * Method to add an employee object to the set of employees for the building.
     * @param employee This is an Employee parameter passed and added to the set.
     */
    public void setSingleEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Method to add an apartment owner object to the set of apartment owners for the building.
     * @param apartmentOwner This is an ApartmentOwner parameter passed and added to the set.
     */
    public void setSingleApartmentOwner(ApartmentOwner apartmentOwner) {
        apartmentOwners.add(apartmentOwner);
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

