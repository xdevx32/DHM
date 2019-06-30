package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class Building implements java.io.Serializable{

    /*
    *
    *  Properties
    *
    */

    private Integer idBuilding;

    private String address;

    private Integer floors;

    private Integer apartmentsCount;

    private Double area;

    private Integer sharedParts;






}
