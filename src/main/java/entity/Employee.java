package entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "employee")
public class Employee implements java.io.Serializable {

    /*
     *
     * Properties
     *
     */

    private Integer idEmployee;

    private String name;

    private String egn;

    private Company company;

    /*
     *
     * Getters with annotations
     *
     */

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idEmployee", unique = true, nullable = false)
    public Integer getIdEmployee() {
        return idEmployee;
    }

    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    @Column(name = "egn", length = 10)
    public String getEgn() {
        return egn;
    }

    @ManyToOne
    @JoinColumn(name = "idCompany", nullable = true)
    public Company getCompany() {
        return company;
    }

    /*
     *
     * Setters
     *
     */

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /*
     *
     * Constructors
     *
     */

    public Employee() {

    }

    public Employee(String name, String egn) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.egn = egn;
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