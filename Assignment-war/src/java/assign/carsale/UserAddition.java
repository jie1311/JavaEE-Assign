/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale;

import assign.carsale.entities.Person;
import java.security.MessageDigest;
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
@Named(value = "userAddition")
@ViewScoped
public class UserAddition {

    private Person newPerson;
    private CarsaleApplication app;

    /**
     * Creates a new instance of UserAddition
     */
    public UserAddition() {
        this.newPerson = new Person();
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        this.app = (CarsaleApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context, null, "carsaleApplication");
    }

    public Person getNewPerson() {
        return newPerson;
    }

    public void setNewPerson(Person newPerson) {
        this.newPerson = newPerson;
    }

    public void addPerson() throws Exception {
        String password = this.newPerson.getPassword();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        this.newPerson.setPassword(sb.toString());
        app.addPerson(newPerson);
    }

}
