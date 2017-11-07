/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale;

import assign.carsale.entities.Cars;
import assign.carsale.entities.Person;
import assign.carsale.repository.CarsaleRespository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jiezhang
 */
@ManagedBean
@Named(value = "carsaleApplication")
@ApplicationScoped
public class CarsaleApplication {

    //public static final String APP_TITLE = "Monash Carsale";
    @EJB
    public CarsaleRespository carsale;

    /**
     * Creates a new instance of CarsaleApplication
     */
    public CarsaleApplication() {

    }

    public List<Cars> getAllCars() throws Exception {
        return carsale.getAllCars();
    }

    public Cars searchCarByNo(int no) throws Exception {
        return carsale.searchCarById(no);
    }

    public Set<Cars> searchCarByName(String name) throws Exception {
        return carsale.searchCarByName(name);
    }

    public Set<Cars> searchCarByMake(String make) throws Exception {
        return carsale.searchCarByMake(make);
    }

    public Set<Cars> searchCarByType(String type) throws Exception {
        return carsale.searchCarByType(type);
    }

    public void addCar(Cars car) throws Exception {
        carsale.addCar(car);
    }

    public void deleteCar(int id) throws Exception {
        carsale.deleteCar(id);
    }

    public void editCar(Cars car) throws Exception {
        carsale.editCar(car);
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public List<Person> getAllPersons() throws Exception {
        return carsale.getAllPerson();
    }

    public Person searchById(int id) throws Exception {
        return carsale.searchById(id);
    }

    public void deleteUser(int id) throws Exception {
        carsale.deletePerson(id);
    }

    public List<Person> advancedSearch(int id, String fname, String lname, String type, String email) throws Exception {
        List<Person> rList = new ArrayList<>();
        if (id == 0) {
            List<Integer> list = carsale.advancedSearch(fname, lname, type, email);
            for (int i : list) {
                rList.add(carsale.searchById(i));
            }
        } else {
            Person p = carsale.searchById(id);
            if (p != null) {
                rList.add(p);
            }
        }
        return rList;
    }
    
    public void addPerson(Person p) throws Exception {
        carsale.addPerson(p);
    }
    
    public void editPerson(Person p) throws Exception {
        carsale.editPerson(p);
    }
}
