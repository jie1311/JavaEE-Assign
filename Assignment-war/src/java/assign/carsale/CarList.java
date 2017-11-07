/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale;

import assign.carsale.entities.Cars;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
@Named(value = "carList")
@ViewScoped
public class CarList {
    String pageTitle;
    String searchType;
    String key;

    /**
     * Creates a new instance of CarList
     */
    public CarList() {
        this.pageTitle = "Monash Car Sale";
        this.searchType = "";
        this.key = "";
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Cars> search() throws Exception {
        List<Cars> returnSet = new ArrayList();
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        CarsaleApplication app = (CarsaleApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context, null, "carsaleApplication");
        if (this.searchType.equals("modelNo")) {
            int id = 0;
            try {
                id = Integer.parseInt(key);
            } catch (Exception e) {
            }
            if (id != 0) {
                Cars c = app.searchCarByNo(id);
                if (c != null) {
                    returnSet.add(c);
                }
            }
        } else if (this.searchType.equals("modelName")) {
            Set<Cars> s = app.searchCarByName(key);
            for (Cars c : s) {
                returnSet.add(c);
            }
        } else if (this.searchType.equals("modelMake")) {
            Set<Cars> s = app.searchCarByMake(key);
            for (Cars c : s) {
                returnSet.add(c);
            }
        } else if (this.searchType.equals("modelType")) {
            Set<Cars> s = app.searchCarByType(key);
            for (Cars c : s) {
                returnSet.add(c);
            }
        } else {
            return app.getAllCars();
        }
        return returnSet;
    }
}
