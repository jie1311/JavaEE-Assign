/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale.respository;

import assign.carsale.entities.Cars;
import assign.carsale.entities.Person;
import assign.carsale.entities.Sale;
import assign.carsale.repository.CarsaleRespository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jiezhang
 */
@Stateless
public class CarsaleImpl implements CarsaleRespository {

    @PersistenceContext(unitName = "AssignmentPU")
    private EntityManager entityManager;

    @Override
    public void addCar(Cars car) throws Exception {
        this.entityManager.persist(car);
    }

    @Override
    public List<Cars> getAllCars() throws Exception {
        return this.entityManager.createNamedQuery(Cars.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Cars searchCarById(int id) throws Exception {
        return this.entityManager.find(Cars.class, id);
    }

    @Override
    public Set<Cars> searchCarByName(String name) throws Exception {
        List<Cars> list = this.entityManager.createNamedQuery(Cars.GET_ALL_QUERY_NAME).getResultList();
        Set<Cars> returnSet = new HashSet<>();
        for (Cars c : list) {
            if (c.getName().equals(name)) {
                returnSet.add(c);
            }
        }
        return returnSet;
    }

    @Override
    public Set<Cars> searchCarByMake(String make) throws Exception {
        List<Cars> list = this.entityManager.createNamedQuery(Cars.GET_ALL_QUERY_NAME).getResultList();
        Set<Cars> returnSet = new HashSet<>();
        for (Cars c : list) {
            if (c.getMake().equals(make)) {
                returnSet.add(c);
            }
        }
        return returnSet;
    }

    @Override
    public Set<Cars> searchCarByType(String type) throws Exception {
        List<Cars> list = this.entityManager.createNamedQuery(Cars.GET_ALL_QUERY_NAME).getResultList();
        Set<Cars> returnSet = new HashSet<>();
        for (Cars c : list) {
            if (c.getType().equals(type)) {
                returnSet.add(c);
            }
        }
        return returnSet;
    }

    @Override
    public void addPerson(Person person) throws Exception {
        this.entityManager.persist(person);
    }

    @Override
    public List<Person> getAllPerson() throws Exception {
        return this.entityManager.createNamedQuery(Person.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Person searchById(int id) throws Exception {
        return this.entityManager.find(Person.class, id);
    }

    @Override
    public Person searchByEmail(String email) {
        List<Person> list = this.entityManager.createNamedQuery(Person.GET_ALL_QUERY_NAME).getResultList();
        for (Person p : list) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Set<Person> searchPersonByFirstname(String name) throws Exception {
        List<Person> list = this.entityManager.createNamedQuery(Person.GET_ALL_QUERY_NAME).getResultList();
        Set<Person> returnSet = new HashSet<>();
        for (Person p : list) {
            if (p.getFirstName().equals(name)) {
                returnSet.add(p);
            }
        }
        return returnSet;
    }
    
    public Set<Person> searchPersonByLastname(String name) throws Exception {
        List<Person> list = this.entityManager.createNamedQuery(Person.GET_ALL_QUERY_NAME).getResultList();
        Set<Person> returnSet = new HashSet<>();
        for (Person p : list) {
            if (p.getLastName().equals(name)) {
                returnSet.add(p);
            }
        }
        return returnSet;
    }

    @Override
    public void addSale(Sale sale) throws Exception {
        this.entityManager.persist(sale);
    }
    
    @Override
    public void deleteCar(int id) throws Exception {
        this.entityManager.remove(this.searchCarById(id));
    }
    
    @Override
    public void editCar(Cars c) throws Exception {
        this.entityManager.merge(c);
    }
    
    @Override
    public void deletePerson(int id) throws Exception {
        this.entityManager.remove(this.searchById(id));
    }
    
    @Override
    public List<Integer> advancedSearch(String fname, String lname, String type, String email) {
        CriteriaBuilder b = this.entityManager.getCriteriaBuilder();
        CriteriaQuery q = b.createQuery(Integer[].class);
        Root<Person> r = q.from(Person.class);
        q.select(b.array(r.get("personId").as(Integer.class))).
                where(
                b.like(r.get("firstName").as(String.class), "%" +fname+ "%"), 
                b.like(r.get("lastName").as(String.class), "%" +lname+ "%"), 
                b.like(r.get("email").as(String.class), "%" +email+ "%"));
        
        return this.entityManager.createQuery(q).getResultList();
        
    }

    @Override
    public void editPerson(Person p) throws Exception {
        this.entityManager.merge(p);
    }

}
