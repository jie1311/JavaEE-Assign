/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale.repository;

import assign.carsale.entities.Cars;
import assign.carsale.entities.Person;
import assign.carsale.entities.Sale;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author jiezhang
 */
@Remote
public interface CarsaleRespository {
    public void addCar(Cars car) throws Exception;
    public List<Cars> getAllCars() throws Exception;
    public Cars searchCarById(int id) throws Exception;
    public Set<Cars> searchCarByName(String name) throws Exception;
    public Set<Cars> searchCarByMake(String make) throws Exception;
    public Set<Cars> searchCarByType(String type) throws Exception;
    public void addPerson(Person person) throws Exception;
    public List<Person> getAllPerson() throws Exception;
    public Person searchById(int id) throws Exception;
    public Person searchByEmail(String email);
    public Set<Person> searchPersonByFirstname(String name) throws Exception;
    public void addSale(Sale sale) throws Exception;
    public void deleteCar(int id) throws Exception;
    public void editCar(Cars c) throws Exception;
    public void deletePerson(int id) throws Exception;
    public List<Integer> advancedSearch(String fname, String lname, String type, String email);
    public void editPerson(Person p) throws Exception;
}


