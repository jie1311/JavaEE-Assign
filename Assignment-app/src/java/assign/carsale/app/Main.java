/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale.app;

import assign.carsale.entities.Cars;
import assign.carsale.gui.CarSaleGUI;
import assign.carsale.gui.CarSaleGUIImpl;
import assign.carsale.repository.CarsaleRespository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author jiezhang
 */
public class Main implements ActionListener, ListSelectionListener {

    /**
     * @param args the command line arguments
     */
    private final String name;
    private CarSaleGUI gui;
    
    @EJB
    private static CarsaleRespository carsale;

    public Main(String name) {
        this.name = name;
    }
    
    public void searchById() throws Exception {
        int id = gui.getCarNo();
        
        if (id > 0) {
            Cars car = carsale.searchCarById(id);
            if (car != null) {
                gui.displayCarDetails(car);
            } else {
                gui.displayMessageInDialog("No matches.");
            }
            
        } else {
            gui.displayMessageInDialog("Input is invalid.");
        }
    }
    
    public void initView() {
        this.gui = new CarSaleGUIImpl(this, this);
        
    }
    public static void main(String[] args) {
        final Main agency = new Main("Monash Car Sale");
        agency.initView();
        // TODO code application logic here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == gui.getSearchButton()) {
             try {       
                 this.searchCar();
             } catch (Exception ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
        } else if(e.getSource() == gui.getSearchButton2()) {
             try {
                 this.searchCar();
             } catch (Exception ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
        } else if (e.getSource() == gui.getModelNo()) {
            gui.getModelNo().setSelected(true);
            gui.getModelMake().setSelected(false);
            gui.getModelName().setSelected(false);
            gui.getModelType().setSelected(false);
            gui.getKeyPanel().setVisible(true);
            gui.getTypePanel().setVisible(false);
        } else if (e.getSource() == gui.getModelName()) {
            gui.getModelName().setSelected(true);
            gui.getModelMake().setSelected(false);
            gui.getModelNo().setSelected(false);
            gui.getModelType().setSelected(false);
            gui.getKeyPanel().setVisible(true);
            gui.getTypePanel().setVisible(false);
        } else if (e.getSource() == gui.getModelMake()) {
            gui.getModelMake().setSelected(true);
            gui.getModelName().setSelected(false);
            gui.getModelNo().setSelected(false);
            gui.getModelType().setSelected(false);
            gui.getKeyPanel().setVisible(true);
            gui.getTypePanel().setVisible(false);
        } else if (e.getSource() == gui.getModelType()) {
            gui.getModelType().setSelected(true);
            gui.getModelMake().setSelected(false);
            gui.getModelNo().setSelected(false);
            gui.getModelName().setSelected(false);
            gui.getKeyPanel().setVisible(false);
            gui.getTypePanel().setVisible(true);
        } else {
            System.exit(0);
        }
    }
    
    public void searchCar() throws Exception {
        if (gui.getModelNo().isSelected()) {
            int id = gui.getCarNo();
            if (id != 0) {
                Cars car = carsale.searchCarById(id);
                if (car != null) {
                    gui.clearTab();
                    gui.addCar(car);
                } else {
                    gui.displayMessageInDialog("No matches");
                } 
            } else {
                gui.displayMessageInDialog("Input is invalid.");
            }   
        } else if (gui.getModelName().isSelected()) {
            Set<Cars> cars = carsale.searchCarByName(gui.getInputText());
            if(!cars.isEmpty()) {
                gui.clearTab();
                gui.addCars(cars);
            } else {
                gui.displayMessageInDialog("No matches");
            }
        } else if (gui.getModelMake().isSelected()) {
            Set<Cars> cars = carsale.searchCarByMake(gui.getInputText());
            if(!cars.isEmpty()) {
                gui.clearTab();
                gui.addCars(cars);
            } else {
                gui.displayMessageInDialog("No matches");
            }
        } else if (gui.getModelType().isSelected()) {
            Set<Cars> cars = carsale.searchCarByType(gui.getSelectedType());
            if(!cars.isEmpty()) {
                gui.clearTab();
                gui.addCars(cars);
            } else {
                gui.displayMessageInDialog("No matches");
            }
        }
        gui.clearInput();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
         if ((e.getSource() == gui.getOutputTable().getSelectionModel()) && (!e.getValueIsAdjusting())) {
             if (gui.isCarSelected()) {
                 try {
                     int carId = gui.getSelectedCar();
                     Cars car = carsale.searchCarById(carId);
                     this.gui.displayCarDetails(car);
                 } catch (Exception ex) {
                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }           
         }
    }   
}
