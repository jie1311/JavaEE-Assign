/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jiezhang
 */
@Entity
@Table(name = "SALE")
@NamedQueries({@NamedQuery(name = Sale.GET_ALL_QUERY_NAME, query = "SELECT s FROM Sale s")})
public class Sale implements Serializable {
    public static final String GET_ALL_QUERY_NAME = "Sale.getAll";
    
    private int saleId;
    private String saleDate;
    private Person customer;
    private Person saleperson;
    
    private Set<Cars> salecars;

    public Sale() {
        this.salecars = new HashSet<>();
    }

    public Sale(int saleId, String saleDate, Person customer, Person saleperson, Set<Cars> salecars) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.customer = customer;
        this.saleperson = saleperson;
        this.salecars = salecars;
    }

    @Id
    @Column(name = "sale_id")
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public Person getSaleperson() {
        return saleperson;
    }

    public void setSaleperson(Person saleperson) {
        this.saleperson = saleperson;
    }

    public Set<Cars> getSalecars() {
        return salecars;
    }

    public void setSalecars(Set<Cars> salecars) {
        this.salecars = salecars;
    }
    
    
       
}
