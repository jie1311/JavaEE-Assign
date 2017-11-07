/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale.gui;

import assign.carsale.entities.Cars;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

/**
 *
 * @author jiezhang
 */
public interface CarSaleGUI {
    public JRadioButton getModelNo();
    public JRadioButton getModelName();
    public JRadioButton getModelMake();
    public JRadioButton getModelType();
    public JButton getSearchButton();
    public void displayMessageInDialog(String message);
    public void displayCarDetails(Cars car);
    public void addCar(Cars car);
    public void addCars(List<Cars> car);
    public void addCars(Set<Cars> car);
    public int getCarNo();
    public void clearInput();
    public void clearTab();
    public JTable getOutputTable();
    public String getInputText();
    public boolean isCarSelected();
    public int getSelectedCar();
    public JPanel getTypePanel();
    public JPanel getKeyPanel();
    public JButton getSearchButton2();
    public String getSelectedType();
}
