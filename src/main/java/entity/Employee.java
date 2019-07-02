package entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

public class Employee {

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

    public Employee() {

    }

    public Employee(String name, String egn) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.egn = egn;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idEmployee", unique = true, nullable = false)
    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
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
     * Constructors
     *
     */

    @ManyToOne
    @JoinColumn(name = "idCompany", nullable = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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