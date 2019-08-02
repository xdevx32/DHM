package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 *  This is a class that represents an entity for each apartment owner.
 *
 * @author Angel Kukushev
 *
 */
@Entity
@Table(name = "apartment_owner")
public class ApartmentOwner implements java.io.Serializable {

    // Properties

    private Integer idApartmentOwner;

    private String name;

    private String egn;

    private Building building;

    private List<LocalDate> payments = new ArrayList<>(0);

    // Getters with annotations

    /**
     * Get method for id.
     * @return idApartmentOwner This is a value representing the id of an apartment owner.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idApartmentOwner", unique = true, nullable = false)
    public Integer getIdApartmentOwner() {
        return idApartmentOwner;
    }

    /**
     * Get method for name.
     * @return name This is a value representing the name of the apartment owner.
     */
    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    /**
     * Get method for egn(identification number).
     * @return egn  This is a value representing the identity number(egn) of the apartment owner.
     */
    @Column(name = "egn", length = 10)
    public String getEgn() {
        return egn;
    }

    /**
     * Get method for buildings.
     * @return building This is a value representing the building that the apartment owner lives in.
     */
    @Transient
    public Building getBuilding() {
        return building;
    }


    /**
     * Get method for payments.
     * @return payments This is a list that holds all payment dates for an apartment owner. Used for reports and checkups.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_PAYMENT" ), nullable = true)
    public List<LocalDate> getPayments() {
        return payments;
    }

    // Setters

    /**
     * Set method for id property.
     * @param idApartmentOwner  This is an integer that is used in setting the id of the apartment owner.
     */
    public void setIdApartmentOwner(Integer idApartmentOwner) {
        this.idApartmentOwner = idApartmentOwner;
    }

    /**
     * Set method for name property.
     * @param name  This is a variable that is used in setting the name of the apartment owner.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set method for egn property.
     * @param egn  This is a variable that is used in setting the egn number of the apartment owner.
     */
    public void setEgn(String egn) {
        this.egn = egn;
    }

    /**
     * Set method for building object property.
     * @param building  This is an object that is used in setting the building of the apartment owner. The one he lives in.
     */
    public void setBuilding(Building building) {
        this.building = building;
    }

    /**
     * Set method for payments list property.
     * @param payments  This is list that is used in setting the payment dates for an apartment owner.
     */
    public void setPayments(List<LocalDate> payments) {
        this.payments = payments;
    }

    // Constructors

    /**
     * No parameter constructor.
     */
    public ApartmentOwner() {

    }

    /**
     * Constructor used in object creation.
     * @param name This is a string used to set the name of the apartment owner.
     * @param egn This is a string used to set the egn of the apartment owner.
     * @param building This is a Building object used to set the building of the apartment owner.
     */
    public ApartmentOwner(String name, String egn, Building building) {
        this.name = name;
        this.egn = egn;
        this.building = building;
    }

    // Additional

    /**
     * Method to add a payment date for an apartment owner. Only a date is required, since the price is specified,
     * by building.
     * @param date This is a parameter that is passed to the Apartment owner's list of dates and added to it.
     */
    public void addPayment(LocalDate date) {
        payments.add(date);
    }

    /**
     *  Method that returns a string value when required.
     * @return name the name value of an apartment owner object.
     */
    @Override
    public String toString() {
        return name;
    }
}
