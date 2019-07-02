package entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "apartment_owner")
public class ApartmentOwner implements java.io.Serializable {

    /*
    *
    *  Properties
    *
    */

    private Integer idApartmentOwner;

    private String name;

    private String egn;

    private Building building;

    /*
     *
     * Getters with annotations
     *
     */

    public ApartmentOwner() {

    }

    public ApartmentOwner(String name, String egn) {
        this.idApartmentOwner = idApartmentOwner;
        this.name = name;
        this.egn = egn;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idApartmentOwner", unique = true, nullable = false)
    public Integer getIdApartmentOwner() {
        return idApartmentOwner;
    }

    public void setIdApartmentOwner(Integer idApartmentOwner) {
        this.idApartmentOwner = idApartmentOwner;
    }

    /*
     *
     * Setters
     *
     */

    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "egn", length = 10)
    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    /*
     *
     *  Constructors
     *
     */

    @OneToOne(mappedBy = "apartment_owner")
    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
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
