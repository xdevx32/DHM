package entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "building")
public class Building implements java.io.Serializable{

    /*
    *
    *  Properties
    *
    */

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

    /*
     *
     *  Getters with annotations
     *
     */

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idBuilding", unique = true, nullable = false)
    public Integer getIdBuilding() {
        return idBuilding;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "address", length = 40)
    public String getAddress() {
        return address;
    }

    @Column(name = "floors")
    public Integer getFloors() {
        return floors;
    }

    @Column(name = "apartments_count")
    public Integer getApartmentsCount() {
        return apartmentsCount;
    }

    @Column(name = "area")
    public Double getArea() {
        return area;
    }

    @Column(name = "shared_parts")
    public Integer getSharedParts() {
        return sharedParts;
    }

    @OneToMany
    @JoinColumn(name = "idBuilding", nullable = true)
    public Set<ApartmentOwner> getApartmentOwners() {
        return apartmentOwners;
    }

    @Transient
    public Set<Employee> getEmployees() {
        return employees;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    @Column(name = "tax")
    public Double getTax() {
        return tax;
    }

    /*
     *
     * Setters
     *
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setIdBuilding(Integer idBuilding) {
        this.idBuilding = idBuilding;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setApartmentOwners(Set<ApartmentOwner> apartmentOwners) {
        this.apartmentOwners = apartmentOwners;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public void setApartmentsCount(Integer apartmentsCount) {
        this.apartmentsCount = apartmentsCount;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setSharedParts(Integer sharedParts) {
        this.sharedParts = sharedParts;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    /*
     *
     *  Constructors
     *
     */

    public Building() {

    }

    public Building(String name, String address, Integer floors, Integer apartmentsCount, Double area, Integer sharedParts) {
        this.idBuilding = idBuilding;
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.apartmentsCount = apartmentsCount;
        this.area = area;
        this.sharedParts = sharedParts;
    }

    /*
     *
     *  Additional
     *
     */

    public void setSingleEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public String toString() {
        return name;
    }

}

