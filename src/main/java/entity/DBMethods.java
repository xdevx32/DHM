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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *  This is a class that works for database connection.
 *  Implements static methods for saving, deleting, adding specific properties and more.
 *
 * @author Angel Kukushev
 *
 */
public class DBMethods {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // APARTMENT OWNER
    /**
     *  Method to CREATE an APARTMENT OWNER in the database
     * @param name This is a string variable used to set the apartment owner name property.
     * @param egn This is a string variable used to set the apartment owner egn property.
     * @param building This is a Building object used to set the apartment owner building property.
     *
     * @return apartmentOwnerID This is the id of the newly created apartment owner entity.
     */
    public static Integer addApartmentOwner(String name, String egn, Building building) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer apartmentOwnerID = null;

        try {
            tx = session.beginTransaction();
            ApartmentOwner apartmentOwner = new ApartmentOwner(name, egn, building);
            building.setSingleApartmentOwner(apartmentOwner);
            session.update(building);
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

    // APARTMENT OWNER
    /**
     * Method to RETURN an APARTMENT OWNER from the database
     * @param apartmentOwnerID This is an integer value passed for getting the requested apartment owner.
     *
     * @return apartmentOwner This is the id of the newly created apartment owner entity.
     */
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

    // APARTMENT OWNER
    /**
     *  Method to DELETE an APARTMENT OWNER from the database
     *
     * @param idApartmentOwner This is an integer value passed for deleting a specific apartment owner.
     *
     */
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

    // APARTMENT OWNER
    /**
     *  Method to ADD a payment for APARTMENT OWNER to the database
     *
     * @param apartmentOwner This is an ApartmentOwner object passed for assigning a payment on his record.
     * @param date This is a LocalDate object passed for having the exact date of the payment.
     */
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

    // APARTMENT OWNER
    /**
     *  Method to GET all APARTMENT OWNERS from the database
     *
     * @return apartmentOwnerObservableList This is an observable list of all apartment owners in the database.
     */
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

    // APARTMENT OWNER
    /**
     *  Method to GET all DATES for an APARTMENT OWNER from the database
     *
     * @param apartmentOwner This is an ApartmentOwner object passed to get its payment dates.
     *
     * @return dates This is an array list of payment dates for the apartment owner.
     */
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

    // APARTMENT OWNER
    /**
     *  Method to GET all DATES for an APARTMENT OWNER from the database IN JAVA.SQL.DATE Type
     *
     * @param apartmentOwner This is an ApartmentOwner object passed to get its payment dates.
     *
     * @return dates This is an array list of payment dates for the apartment owner.
     */
    public static ArrayList<java.sql.Date> getPaymentDatesForApartmentOwnerSQL(ApartmentOwner apartmentOwner) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List dates = session.createSQLQuery("SELECT payments FROM ApartmentOwner_payments WHERE ApartmentOwner_idApartmentOwner=" + apartmentOwner.getIdApartmentOwner())
                    .list();

            tx.commit();
            return new ArrayList<java.sql.Date>(dates);
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

    // BUILDING
    /**
     *  Method to CREATE a BUILDING in the database
     *
     * @param name This is a string variable used to set the building name property.
     * @param address This is a string variable used to set the building address property.
     * @param floors This is an integer variable used to set the building floors property.
     * @param apartmentsCount This is a integer variable used to set the building apartmentsCount property.
     * @param area This is a double variable used to set the building area property.
     * @param sharedParts This is an integer variable used to set the building sharedParts property.
     *
     * @return buildingID This is the id of the newly created building.
     */
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

    // BUILDING
    /**
     *  Method to RETURN a BUILDING from the database
     *
     * @param buildingID This is an integer value passed to retrieve the building
     *
     * @return building This is the requested building object.
     */
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

    // BUILDING
    /**
     *  Method to DELETE a BUILDING from the database
     *
     * @param idBuilding This is an integer value passed for deleting a specific building.
     *
     */
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

    // BUILDING
    /**
     *  Method to ADD tax to a BUILDING to the database
     *
     * @param building This is a building object that is going to have a tax assigned to.
     * @param tax This is a double value passed to assign tax to a building.
     */
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

    // BUILDING
    /**
     *  Method to GET all BUILDINGS from the database
     *
     * @return buildings This is an array list of all buildings in the database.
     */
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


    // COMPANY
    /**
     *  Method to CREATE a COMPANY in the database
     *
     * @param name This is a string value passed for creating a company in the database.
     *
     * @return companyID This is the id of the newly created company.
     */
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

    // COMPANY
    /**
     *  Method to RETURN a COMPANY from the database
     *
     * @param companyID This is an integer value representing the ID of a company.
     *
     * @return company This is a company object that maps the passed ID parameter.
     */
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

    // COMPANY
    /**
     *  Method to DELETE a COMPANY from the database
     *
     * @param idCompany This is an integer value passed for getting the requested company.
     */
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

    // COMPANY
    /**
     *  Method to GET all COMPANIES from the database
     *
     * @return companyObservableList This is an observable list representing all companies in the database.
     */
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

    // EMPLOYEE
    /**
     * Method to CREATE an EMPLOYEE in the database
     *
     *
     */
    public static Integer addEmployee(String name, String egn, Company company, Building building) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(name, egn, company, building);
            building.setHasService(true);
            session.update(building);
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

    // EMPLOYEE
    /**
     *  Method to RETURN an EMPLOYEE from the database
     *
     * @param employeeID This is an integer value passed for getting the requested employee.
     *
     * @return employee This is the employee object that gets returned from the database query.
     */
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

    // EMPLOYEE
    /** Method to DELETE an EMPLOYEE from the database
    *
    * @param idEmployee This is an integer value passed for deleting a specific employee.
    *
    */
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

    // EMPLOYEE
    /**
     * Method to GET all EMPLOYEES from the database
     *
     * @return employeeObservableList This is an observable list representing all employees in the database.
     */
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


    // BUILDING & EMPLOYEE
    /**
     *  Method to ADD a BUILDING maintained by an EMPLOYEE
     *
     * @param building This is a building object that will be assigned to an employee.
     * @param employee This is an employee object that will be assigned to a building.
     *
     */
    public static void addBuildingToAnEmployee(Building building, Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            building.setHasService(true);
            employee.setSingleBuilding(building);
            session.update(employee);
            session.update(building);
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

    // BUILDING & EMPLOYEE
    /**
     *  Method to RETURN all BUILDINGS for a specific EMPLOYEE
     *
     * @param employee This is an employee object passed to retrieve its list of building objects.
     *
     * @return buildings This is a list of buildings for the passed employee.
     */
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

    // BUILDING & APARTMENT OWNER
    /**
     * Method to get LIST of APARTMENT OWNERS for a BUILDING
     *
     * @param building This is the building object passed to retrieve its apartment owners.
     *
     * @return apartmentOwners This is a list of apartment for the passed building.
     */
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

    // BUILDING & APARTMENT OWNER
    /**
    *  Method to get the BUILDING of an APARTMENT OWNER
    *  Note: The method uses raw sql query, since the requested object
    *  is mapped in non traditional way. HQL query was not possible, so
    *  the solution was to use SQL.
    *
    * @param aptOwner This is an ApartmentOwner object passed to complete the query.
    *
    * @return building This is the Building object that corresponds to the passed apartment owner
    */
    public static Building getBuildingForApartmentOwner(ApartmentOwner aptOwner) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Integer idBuilding =  (Integer)session.createSQLQuery("SELECT idBuilding FROM apartment_owner WHERE idApartmentOwner=" + aptOwner.getIdApartmentOwner()).getSingleResult();

            Building building = session.get(Building.class, idBuilding);
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
}