package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "apartment_owner")
public class ApartmentOwner implements java.io.Serializable {

    /*
    *
    *  Properties
    *
    */

    Integer idApartmentOwner;

    String name;

    String egn;
}
