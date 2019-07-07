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

import java.util.ArrayList;
import java.util.List;


public class DBMethods {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // Status: Needs testing
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

    // Status: Needs testing
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

    // Status: Needs testing
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

    //Status: Needs testing
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

    // Status: Needs testing
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

    // Status: Needs testing
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

    //Status: Needs testing
    /* BUILDING */
    /* Method to DELETE a BUILDING from the database*/
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

    //Status: Needs testing
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


    // Status: Needs testing
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

    // Status: Needs testing
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

    // Status: Needs testing
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

    //Status: Needs testing
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

    // Status: Needs testing
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

    // Status: Needs testing
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

    // Status: Needs testing
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

    //Status: Needs testing
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


    // Status: Ready for one
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
    /* Method to RETURN all facilities FOR A SPECIFIC PARK*/
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

//
//    // Status: Ready for one
//    // Add multiple adding
//    /* FACILITY */
//    /* Method to ADD a facility to a PARK */
//    public static void addFacilityForSpecificPark(Integer idPark, Facility facility) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//
//            Park park = session.get(Park.class, idPark);
//            park.setSingleFacility(facility);
//            session.update(park);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            AlertErrorUtility.showCustomAlert("Съоражението вече съществува в парка.");
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//    // Status: Ready
//    /* FACILITY */
//    /* Method to RETURN a facility from the database */
//    public static Facility getFacility(Integer facilityID) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Facility facility = session.get(Facility.class, facilityID);
//            tx.commit();
//            return facility;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }

}




















//
//    // Status: Ready
//    /* FACILITY */
//    /* Method to RETURN a facility from the database */
//    public static Facility getFacility(Integer facilityID) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Facility facility = session.get(Facility.class, facilityID);
//            tx.commit();
//            return facility;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    // Status: Consider removing
//    /* FACILITY */
//    /* Method to LIST all the facilities */
//    public static void listFacilitiesForSelectedPark(Park park) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//
//            //String hql = "SELECT P.facilities FROM "+ Park.class.getSimpleName() + " P WHERE P.idPark=" + park.getIdPark();
//            //String hql = "FROM Park WHERE Park_idPark=" + park.getIdPark();
//            //List facilities = session.createQuery(hql).list();
//
//            Set<Facility> facilities = park.getFacilities();
//
//            for (Iterator iterator = facilities.iterator(); iterator.hasNext();) {
//                Facility facility = (Facility) iterator.next();
//                System.out.println(" Name: " + facility.getName() + "Minimal Age: " + facility.getMinAge());
//            }
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    // Status: Ready
//    /* FACILITY */
//    /* Method to DELETE a facility by id */
//    public static void deleteFacility(Integer idFacility) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Facility facility = session.get(Facility.class, idFacility);
//            session.delete(facility);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    // Status: Ready
//    /* FACILITY */
//    /* Method to RETURN all facilities */
//    public static ObservableList<Facility> getFacilities() {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            List facilities = session.createQuery("FROM " + Facility.class.getSimpleName()).list();
//            ObservableList<Facility> facilityObservableList = FXCollections.observableArrayList(facilities);
//            tx.commit();
//            return facilityObservableList;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    // Status: Ready
//    /* FACILITY */
//    /* Method to RETURN all facilities FOR A SPECIFIC PARK*/
//    public static ObservableList<Facility> getFacilitiesForSpecificPark(Park park) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//
//            List facilities = session.createQuery("select p.facilities from Park p where p.idPark=:idPark")
//                    .setParameter("idPark", park.getIdPark())
//                    .list();
//
//            ObservableList<Facility> facilityObservableList = FXCollections.observableArrayList(facilities);
//            tx.commit();
//            return facilityObservableList;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    // Status: Ready
//    /* PARK */
//    /* Method to CREATE a park in the database */
//    public static Integer addPark(String name, Double entryTicketPrice) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        Integer parkID = null;
//
//        try {
//            tx = session.beginTransaction();
//            Park park = new Park(name,entryTicketPrice);
//            parkID = (Integer) session.save(park);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return parkID;
//    }
//
//    // Status: Rework
//    /* PARK */
//    /* Method to CREATE a park WITH FACILITIES AND MANAGER in the database */
//    public static Integer addPark(String name, Double entryTicketPrice, Manager manager, HashSet<Facility> facilities) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        Integer parkID = null;
//
//        try {
//            tx = session.beginTransaction();
//            Park park = new Park(name, entryTicketPrice, manager, facilities);
//            parkID = (Integer) session.save(park);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return parkID;
//    }
//
//    // Status: Ready
//    /* PARK */
//    /* Method to RETURN a park from the database */
//    public static Park getPark(Integer parkID) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Park park = session.get(Park.class, parkID);
//            tx.commit();
//            return park;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    // Status: Ready
//    /* PARK */
//    /* Method to DELETE a park by id */
//    public static void deletePark(Integer idPark) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Park park = session.get(Park.class, idPark);
//            session.delete(park);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    // Status: Ready
//    /* PARK */
//    /* Method to RETURN all parks */
//    public static ObservableList<Park> getParks() {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            List parks = session.createQuery("FROM " + Park.class.getSimpleName()).list();
//            ObservableList<Park> parkObservableList = FXCollections.observableArrayList(parks);
//            tx.commit();
//            return parkObservableList;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    // Status: Ready
//    /* KID */
//    /* Method to CREATE a kid in the database */
//    public static Integer addKid(Integer age) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        Integer kidID = null;
//
//        try {
//            tx = session.beginTransaction();
//            Kid kid = new Kid(age);
//            kidID = (Integer) session.save(kid);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return kidID;
//    }
//
//    // Status: Ready
//    /* KID */
//    /* Method to RETURN a kid from the database */
//    public static Kid getKid(Integer kidID) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Kid kid = session.get(Kid.class, kidID);
//            tx.commit();
//            return kid;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    // Status: Ready
//    /* KID */
//    /* Method to DELETE a kid by id */
//    public static void deleteKid(Integer idKid) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Kid kid = session.get(Kid.class, idKid);
//            session.delete(kid);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    // Status: Ready
//    /* KID */
//    /* Method to RETURN all kids */
//    public static ObservableList<Kid> getKids() {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            List kids = session.createQuery("FROM " + Kid.class.getSimpleName()).list();
//            ObservableList<Kid> kidObservableList = FXCollections.observableArrayList(kids);
//            tx.commit();
//            return kidObservableList;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    // Status: Ready
//    /* KID */
//    /* METHOD to add a KID visitor to the database */
//    public static void addKidVisitorToPark(Integer idPark, Kid kid) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Park park = session.get(Park.class, idPark);
//            park.setSingleKidVisitor(kid);
//            session.update(park);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    // Status: Ready
//    /* MANAGER */
//    /* Method to CREATE a manager in the database */
//    public static Integer addManager(String managerName, Double managerSalary) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        Integer managerID = null;
//
//        try {
//            tx = session.beginTransaction();
//            Manager manager = new Manager(managerName, managerSalary);
//            managerID = (Integer) session.save(manager);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return managerID;
//
//    }
//
//    // Status: Ready
//    /* MANAGER */
//    /* Method to ADD a manager to a PARK */
//    public static void addManagerForSpecificPark(Integer idPark, Manager manager) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//
//            Park park = session.get(Park.class, idPark);
//            park.setManager(manager);
//            session.update(park);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    // Status: Ready
//    /* MANAGER */
//    /* Method to RETURN a manager from the database */
//    public static Manager getManager(Integer managerId) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Manager manager = session.get(Manager.class, managerId);
//            tx.commit();
//            return manager;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//
//    }
//
//    // Status: Ready
//    /* MANAGER */
//    /* Method to RETURN all managers */
//    public static ObservableList<Manager> getManagers() {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            List managers = session.createQuery("FROM " + Manager.class.getSimpleName()).list();
//            ObservableList<Manager> managerObservableList = FXCollections.observableArrayList(managers);
//            tx.commit();
//            return managerObservableList;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    // Status: Consider removing
//    /* MANAGER */
//    /* Method to LIST all the managers */
//    public static void listManagers() {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            List managers = session.createQuery("FROM " + Manager.class.getName()).list();
//            for (Iterator iterator = managers.iterator(); iterator.hasNext();) {
//                Manager manager = (Manager) iterator.next();
//                System.out.println(" Name: " + manager.getName() + "Salary: " + manager.getSalary());
//            }
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    // Status: Ready
//    /* MANAGER */
//    public static void updateManagerSalary(Integer idManager, Double newSalary) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//
//            Manager manager = session.get(Manager.class, idManager);
//            manager.setSalary(newSalary);
//            manager.setHasPromotion(true);
//            session.update(manager);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    // Status: Ready
//    /* MANAGER */
//    public static void deleteManager(Integer idManager) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Manager manager = session.get(Manager.class, idManager);
//            Park park = manager.getPark();
//            park.unsetManager();
//            session.update(park);
//            session.delete(manager);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
