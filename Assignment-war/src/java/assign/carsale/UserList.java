/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale;

import assign.carsale.entities.Person;
import java.util.List;
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
@Named(value="userList")
@ViewScoped
public class UserList {
    private String personId;
    private String fname;
    private String lname;
    private String email;
    private boolean getAll;

    /**
     * Creates a new instance of UserList
     */
    public UserList() {
        this.personId = "";
        this.email = "";
        this.fname = "";
        this.lname = "";
        this.getAll = true;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGetAll() {
        return getAll;
    }

    public void setGetAll(boolean getAll) {
        this.getAll = getAll;
    }
    
    public List<Person> search() throws Exception {
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        CarsaleApplication app = (CarsaleApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context, null, "carsaleApplication");
        int iid;
        try {
            iid = Integer.parseInt(personId);
        } catch (Exception e) {
            iid = 0;
        }
        
        if (getAll) {
            return app.getAllPersons();
        } else {
        return app.advancedSearch(iid, fname, lname, fname, email);
        }
    }
    
}
