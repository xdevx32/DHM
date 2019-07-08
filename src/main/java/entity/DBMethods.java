/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utility.AlertErrorUtility;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DBMethods {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // Status: Done
    /* APARTMENT OWNER */
    /* Method to CREATE an APARTMENT OWNER in the database*/
    public static Integer addApartmentOwner(String name, String egn) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer apartmentOwnerID = null;

        try {
            tx = session.beginTransaction();
            ApartmentOwner apartmentOwner = new ApartmentOwner(name, egn);
            apartmentOwnerID = (Integer) session.save(apartmentOwner);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return apartmentOwnerID;
    }

    // Status: Done
    /* APARTMENT OWNER */
    /* Method to RETURN an APARTMENT OWNER from the database */
    public static ApartmentOwner getApartmentOwner(Integer apartmentOwnerID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            ApartmentOwner apartmentOwner = session.get(ApartmentOwner.class, apartmentOwnerID);
            tx.commit();
            return apartmentOwner;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: TODO
    /* APARTMENT OWNER */
    /* Method to UPDATE an APARTMENT OWNER in the database*/

    // Status: Done
    /* APARTMENT OWNER */
    /* Method to DELETE an APARTMENT OWNER from the database*/
    public static void deleteApartmentOwner(Integer idApartmentOwner) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            ApartmentOwner apartmentOwner = session.get(ApartmentOwner.class, idApartmentOwner);
            session.delete(apartmentOwner);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Status: Done
    /* APARTMENT OWNER */
    /* Method to ADD a payment for APARTMENT OWNER to the database*/
    public static void addPaymentToApartmentOwner(ApartmentOwner apartmentOwner, LocalDate date) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            apartmentOwner.addPayment(date);
            session.update(apartmentOwner);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //Status: Done
    /* APARTMENT OWNER */
    /* Method to GET all APARTMENT OWNERS from the database*/
    public static ObservableList<ApartmentOwner> getApartmentOwners() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List apartmentOwners = session.createQuery("FROM " + ApartmentOwner.class.getSimpleName()).list();
            ObservableList<ApartmentOwner> apartmentOwnerObservableList = FXCollections.observableArrayList(apartmentOwners);
            tx.commit();
            return apartmentOwnerObservableList;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: Done
    /* APARTMENT OWNER */
    /* Method to GET all DATES for an APARTMENT OWNER from the database*/
    public static ArrayList<LocalDate> getPaymentDatesForApartmentOwner(ApartmentOwner apartmentOwner) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List dates = session.createSQLQuery("SELECT payments FROM ApartmentOwner_payments WHERE ApartmentOwner_idApartmentOwner=" + apartmentOwner.getIdApartmentOwner())
                    .list();

            tx.commit();
            return new ArrayList<LocalDate>(dates);
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    /* APARTMENT OWNER */
    /* Method to add APARTMENT OWNER for a BUILDING*/
    public static void addApartmentOwnerToBuilding(Building building, ApartmentOwner apartmentOwner) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            building.setSingleApartmentOwner(apartmentOwner);
            session.update(building);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Status: Done
    /* BUILDING */
    /* Method to CREATE a BUILDING in the database */
    public static Integer addBuilding(String name, String address,
                                   Integer floors, Integer apartmentsCount, Double area, Integer sharedParts) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer buildingID = null;

        try {
            tx = session.beginTransaction();
            Building building = new Building(name, address, floors, apartmentsCount, area, sharedParts);
            buildingID = (Integer) session.save(building);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return buildingID;
    }

    // Status: Done
    /* BUILDING */
    /* Method to RETURN a BUILDING from the database */
    public static Building getBuilding(Integer buildingID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Building building = session.get(Building.class, buildingID);
            tx.commit();
            return building;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: TODO
    /* BUILDING */
    /* Method to UPDATE a building in the database*/

    //Status: Done
    /* BUILDING */
    /* Method to DELETE a BUILDING from the database */
    public static void deleteBuilding(Integer idBuilding) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Building building = session.get(Building.class, idBuilding);
            session.delete(building);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* BUILDING */
    /* Method to ADD tax to a BUILDING to the database */
    public static void addTaxToBuilding(Building building, Double tax){
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            building.setTax(tax);
            session.update(building);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //Status: Done
    /* BUILDING */
    /* Method to GET all BUILDINGS from the database*/
    public static ArrayList<Building> getBuildings() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Building> buildings = session.createQuery("FROM " + Building.class.getSimpleName()).list();
            tx.commit();
            return new ArrayList<Building>(buildings);
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


    // Status: Done
    /* COMPANY */
    /* Method to CREATE a COMPANY in the database*/
    public static Integer addCompany(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer companyID = null;

        try {
            tx = session.beginTransaction();
            Company company = new Company(name);
            companyID = (Integer) session.save(company);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return companyID;
    }

    // Status: Done
    /* COMPANY */
    /* Method to RETURN a COMPANY from the database */
    public static Company getCompany(Integer companyID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Company company = session.get(Company.class, companyID);
            tx.commit();
            return company;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: TODO
    /* COMPANY */
    /* Method to UPDATE a COMPANY in the database*/

    // Status: Done
    /* COMPANY */
    /* Method to DELETE a COMPANY from the database*/
    public static void deleteCompany(Integer idCompany) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Company company = session.get(Company.class, idCompany);
            session.delete(company);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //Status: Done
    /* COMPANY */
    /* Method to GET all COMPANIES from the database*/
    public static ObservableList<Company> getCompanies() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List companies = session.createQuery("FROM " + Company.class.getSimpleName()).list();
            ObservableList<Company> companyObservableList = FXCollections.observableArrayList(companies);
            tx.commit();
            return companyObservableList;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: Done
    /* EMPLOYEE */
    /* Method to CREATE an EMPLOYEE in the database*/
    public static Integer addEmployee(String name, String egn, Company company, Building building) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(name, egn, company, building);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    // Status: Done
    /* EMPLOYEE */
    /* Method to RETURN an EMPLOYEE from the database */
    public static Employee getEmployee(Integer employeeID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeID);
            tx.commit();
            return employee;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: TODO
    /* EMPLOYEE */
    /* Method to UPDATE an EMPLOYEE in the database*/

    // Status: Done
    /* EMPLOYEE */
    /* Method to DELETE an EMPLOYEE from the database*/
    public static void deleteEmployee(Integer idEmployee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, idEmployee);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //Status: Done
    /* EMPLOYEE */
    /* Method to GET all EMPLOYEES from the database*/
    public static ObservableList<Employee> getEmployees() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM " + Employee.class.getSimpleName()).list();
            ObservableList<Employee> employeeObservableList = FXCollections.observableArrayList(employees);
            tx.commit();
            return employeeObservableList;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


    // Status: Done
    /* BUILDING & EMPLOYEE */
    /* Method to ADD a BUILDING maintained by an EMPLOYEE */
    public static void addBuildingToAnEmployee(Building building, Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            employee.setSingleBuilding(building);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            AlertErrorUtility.showCustomAlert("Служителя вече обслужва сградата.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Status: Ready
    /* BUILDING & EMPLOYEE */
    /* Method to RETURN all BUILDINGS for a specific EMPLOYEE*/
    public static ArrayList<Building> getBuildingsForEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List buildings = session.createQuery("select e.buildings from Employee e where e.idEmployee=:idEmployee")
                    .setParameter("idEmployee", employee.getIdEmployee())
                    .list();

            tx.commit();
            return new ArrayList<Building>(buildings);
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    /* BUILDING & APARTMENT OWNER */
    /* */
    public static ArrayList<ApartmentOwner> getApartmentOwnersForBuilding(Building building) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List apartmentOwners = session.createQuery("select b.apartmentOwners from Building b where b.idBuilding=:idBuilding")
                    .setParameter("idBuilding", building.getIdBuilding())
                    .list();

            tx.commit();
            return new ArrayList<ApartmentOwner>(apartmentOwners);
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

}