package entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private List<LocalDate> payments = new ArrayList<LocalDate>(0);

    /*
     *
     * Getters with annotations
     *
     */

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idApartmentOwner", unique = true, nullable = false)
    public Integer getIdApartmentOwner() {
        return idApartmentOwner;
    }

    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    @Column(name = "egn", length = 10)
    public String getEgn() {
        return egn;
    }

    @Transient
    public Building getBuilding() {
        return building;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    public List<LocalDate> getPayments() {
        return payments;
    }

    /*
     *
     * Setters
     *
     */

    public void setIdApartmentOwner(Integer idApartmentOwner) {
        this.idApartmentOwner = idApartmentOwner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setPayments(List<LocalDate> payments) {
        this.payments = payments;
    }

    /*
     *
     *  Constructors
     *
     */

    public ApartmentOwner() {

    }

    public ApartmentOwner(String name, String egn, Building building) {
        this.idApartmentOwner = idApartmentOwner;
        this.name = name;
        this.egn = egn;
        this.building = building;
    }

    /*
     *
     *  Additional
     *
     */

    public void addPayment(LocalDate date) {
        payments.add(date);
    }

    @Override
    public String toString() {
        return name;
    }
}
