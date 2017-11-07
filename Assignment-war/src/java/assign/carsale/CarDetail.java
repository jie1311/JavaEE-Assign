package assign.carsale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import assign.carsale.entities.Cars;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Named(value = "catDetail")
@ViewScoped
public class CarDetail {

    private int carId;
    private Cars car;
    private CarsaleApplication app;

    /**
     * Creates a new instance of CarDetail
     */
    public CarDetail() {
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        app = (CarsaleApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context, null, "carsaleApplication");
        try {
            this.carId = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("carId"));
            this.car = searchCar(this.carId);
        } catch (Exception ex) {
            Logger.getLogger(CarDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public Cars searchCar(int id) throws Exception {
        return app.searchCarByNo(id);
    }

    public void deleteCar() throws Exception {
        app.deleteCar(carId);
    }   
    
    
}
