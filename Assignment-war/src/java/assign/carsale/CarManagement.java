/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale;

import assign.carsale.entities.Cars;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jiezhang
 */
@ManagedBean
@Named(value = "carManagement")
@ViewScoped
public class CarManagement {
    
    private Cars newCar;
    private CarsaleApplication app;

    /**
     * Creates a new instance of CarManagement
     */
    public CarManagement() {
        this.newCar = new Cars();
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        this.app = (CarsaleApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context, null, "carsaleApplication");
        
    }
    
    public void addCar() throws Exception {
        if (app.searchCarByNo(newCar.getCarId()) == null) {
            app.addCar(newCar);
        }
    }

    public boolean checkCar() throws Exception {
        return (app.searchCarByNo(newCar.getCarId()) == null);
    }

    public Cars getNewCar() {
        return newCar;
    }

    public void setNewCar(Cars newCar) {
        this.newCar = newCar;
    }
    
    
}
