/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jiezhang
 */
@Entity
@Table(name = "CARS")
@NamedQueries({@NamedQuery(name = Cars.GET_ALL_QUERY_NAME, query = "SELECT c FROM Cars c")})
public class Cars implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Cars.getAll";
    
    private int carId;
    private String vin;
    private String name;
    private String make;
    private String type;
    private String thumbnail;
    private String description;
    private String previreUrl;

    public Cars() {
    }

    public Cars(int carId, String vin, String name, String make, String type, String thumbnail, String description, String previreUrl) {
        this.carId = carId;
        this.vin = vin;
        this.name = name;
        this.make = make;
        this.type = type;
        this.thumbnail = thumbnail;
        this.description = description;
        this.previreUrl = previreUrl;
    }

    @Id
    @GeneratedValue
    @Column(name = "car_id")
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrevireUrl() {
        return previreUrl;
    }

    public void setPrevireUrl(String previreUrl) {
        this.previreUrl = previreUrl;
    }
    
    @Override
    public String toString() {
        return "Model No.: " + this.carId + "; Model Name:" + this.name; 
    }
    
    
}
