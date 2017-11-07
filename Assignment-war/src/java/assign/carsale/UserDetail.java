/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale;

import assign.carsale.entities.Person;
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
@Named(value="userDetail")
@ViewScoped
public class UserDetail {
    private int userId;
    private Person person;
    private CarsaleApplication app;

    /**
     * Creates a new instance of UserDetail
     */
    public UserDetail() throws Exception {
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        app = (CarsaleApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context, null, "carsaleApplication");
        this.userId = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("carId"));
        this.person = app.searchById(userId);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void deleteUser() throws Exception {
        app.deleteCar(userId);
    }
    
}
