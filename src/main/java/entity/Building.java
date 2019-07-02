package entity;

import javax.persistence.*;

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

    private ApartmentOwner apartmentOwner;


    /*
     *
     *  Getters with annotations
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

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idBuilding", unique = true, nullable = false)
    public Integer getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(Integer idBuilding) {
        this.idBuilding = idBuilding;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", length = 40)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*
     *
     * Setters
     *
     */

    @Column(name = "floors")
    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    @Column(name = "apartments_count")
    public Integer getApartmentsCount() {
        return apartmentsCount;
    }

    public void setApartmentsCount(Integer apartmentsCount) {
        this.apartmentsCount = apartmentsCount;
    }

    @Column(name = "area")
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Column(name = "shared_parts")
    public Integer getSharedParts() {
        return sharedParts;
    }

    public void setSharedParts(Integer sharedParts) {
        this.sharedParts = sharedParts;
    }

    /*
     *
     *  Constructors
     *
     */

    @OneToOne
    public ApartmentOwner getApartmentOwner() {
        return apartmentOwner;
    }

    public void setApartmentOwner(ApartmentOwner apartmentOwner) {
        this.apartmentOwner = apartmentOwner;
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

