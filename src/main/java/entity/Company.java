package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company implements java.io.Serializable {

    /*
     *
     *  Properties
     *
     */

    private Integer idCompany;

    private String name;

    private Set<Employee> employees = new HashSet<Employee>(0);

}
