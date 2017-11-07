/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign.carsale.gui;

import assign.carsale.entities.Cars;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jiezhang
 */
public class CarSaleGUIImpl extends JFrame implements CarSaleGUI  {
    private static final String[] TABLE_COLUMNS = {"No.", "Name", "Make"};
    private static final String[] TYPE = {"Sedan", "4-Wheel-Drive", "Truck"};
    
    private final JPanel searchPanel;
    private final JLabel searchBy;
    private final JRadioButton modelNo;
    private final JRadioButton modelName;
    private final JRadioButton modelMake;
    private final JRadioButton modelType;
    
    private final JPanel keyPanel;
    private final JLabel keyWord;
    private final JTextField keyTextField;
    private final JButton searchButton;
    
    private final JPanel typePanel;
    private final JLabel typeLabel;
    private final JComboBox typeCombo;
    private final JButton searchButton2;
    
    private final JPanel tabPanel;
    private final JTable outputTable;
    
    private final JPanel detailPanel;
    private final JLabel carModelNo;
    private final JTextField carModelNoShow;
    private final JLabel carModelVin;
    private final JTextField carModelVinShow;
    private final JLabel carModelName;
    private final JTextField carModelNameShow;
    private final JLabel carModelMake;
    private final JTextField carModelMakeShow;
    private final JLabel carModelType;
    private final JTextField carModelTypeShow;  
    private final JLabel carModelThumnail;
    private final JTextField carModelThumnailShow;
    private final JLabel carModelDescription;
    private final JTextField carModelDescriptionShow;
    private final JLabel carModelPreviewURL;
    private final JTextField carModelPreviewURLShow;
        
    public CarSaleGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener) {
        
        this.searchPanel = new JPanel(new GridLayout(1, 5));
        this.searchBy = new JLabel("     Search By:");
        this.modelNo = new JRadioButton("Model No.");
        this.modelNo.setSelected(true);
        this.modelName = new JRadioButton("Model Name");
        this.modelMake = new JRadioButton("Model Make");
        this.modelType = new JRadioButton("Model Type");
        this.modelNo.addActionListener(actionListener);
        this.modelName.addActionListener(actionListener);
        this.modelMake.addActionListener(actionListener);
        this.modelType.addActionListener(actionListener);
        this.searchPanel.add(this.searchBy);
        this.searchPanel.add(this.modelNo);
        this.searchPanel.add(this.modelName);
        this.searchPanel.add(this.modelMake);
        this.searchPanel.add(this.modelType);
        
        
        this.keyPanel = new JPanel(new GridLayout(1, 3));
        this.keyWord = new JLabel("     Key Word:");
        this.keyTextField = new JTextField();
        this.searchButton = new JButton("Search");
        this.searchButton.addActionListener(actionListener);
        this.keyPanel.add(this.keyWord);
        this.keyPanel.add(this.keyTextField);
        this.keyPanel.add(this.searchButton);
        
        
        this.typePanel = new JPanel(new GridLayout(1,3));
        this.typeLabel = new JLabel("     Select Type:");
        this.typeCombo = new JComboBox();
        for (String item : TYPE) {
            this.typeCombo.addItem(item);
        }
        this.searchButton2 = new JButton("Search");
        this.searchButton2.addActionListener(actionListener);
        this.typePanel.add(this.typeLabel);
        this.typePanel.add(this.typeCombo);
        this.typePanel.add(this.searchButton2);
        this.typePanel.setVisible(false);
        
        this.tabPanel = new JPanel(new GridLayout());
        this.outputTable = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        this.outputTable.getSelectionModel().addListSelectionListener(listSelectionListener);
        JScrollPane outputTableScrollPane = new JScrollPane(this.outputTable);
        this.tabPanel.add(outputTableScrollPane);
        
        
        this.detailPanel = new JPanel(new GridLayout(8, 2));
        this.carModelNo = new JLabel("     Model No.:");
        this.carModelVin = new JLabel("     Model VIN:");
        this.carModelName = new JLabel("     Model Name:");
        this.carModelMake = new JLabel("     Model Make:");
        this.carModelType = new JLabel("     Model Type:");
        this.carModelThumnail = new JLabel("     Model Thumbnail:");
        this.carModelDescription = new JLabel("     Model Description:");
        this.carModelPreviewURL = new JLabel("     Model Preview URL:");
        this.carModelNoShow = new JTextField();
        this.carModelVinShow = new JTextField();
        this.carModelNameShow = new JTextField();
        this.carModelMakeShow = new JTextField();
        this.carModelTypeShow = new JTextField();
        this.carModelThumnailShow = new JTextField();
        this.carModelDescriptionShow = new JTextField();
        this.carModelPreviewURLShow = new JTextField();
        this.detailPanel.add(this.carModelNo);
        this.detailPanel.add(this.carModelNoShow);
        this.detailPanel.add(this.carModelVin);
        this.detailPanel.add(this.carModelVinShow);
        this.detailPanel.add(this.carModelName);
        this.detailPanel.add(this.carModelNameShow);
        this.detailPanel.add(this.carModelMake);
        this.detailPanel.add(this.carModelMakeShow);
        this.detailPanel.add(this.carModelType);
        this.detailPanel.add(this.carModelTypeShow);
        this.detailPanel.add(this.carModelThumnail);
        this.detailPanel.add(this.carModelThumnailShow);
        this.detailPanel.add(this.carModelDescription);
        this.detailPanel.add(this.carModelDescriptionShow);
        this.detailPanel.add(this.carModelPreviewURL);
        this.detailPanel.add(this.carModelPreviewURLShow);
        this.detailPanel.setVisible(false);

        
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(this.searchPanel);
        container.add(this.keyPanel);
        container.add(this.typePanel);
        container.add(this.tabPanel);
        container.add(this.detailPanel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);        
    }

    @Override
    public JRadioButton getModelNo() {
        return modelNo;
    }

    @Override
    public JRadioButton getModelName() {
        return modelName;
    }

    @Override
    public JRadioButton getModelMake() {
        return modelMake;
    }

    @Override
    public JRadioButton getModelType() {
        return modelType;
    }

    @Override
    public JButton getSearchButton() {
        return searchButton;
    }
      
    @Override
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    @Override
    public void displayCarDetails(Cars car) {
        this.carModelNoShow.setText(car.getCarId() + "");
        this.carModelNoShow.setEditable(false);
        this.carModelNameShow.setText(car.getName());
        this.carModelNameShow.setEditable(false);
        this.carModelMakeShow.setText(car.getMake());
        this.carModelMakeShow.setEditable(false);
        this.carModelTypeShow.setText(car.getType());
        this.carModelTypeShow.setEditable(false);
        this.carModelDescriptionShow.setText(car.getDescription());
        this.carModelDescriptionShow.setEditable(false);
        this.carModelVinShow.setText(car.getVin());
        this.carModelVinShow.setEditable(false);
        this.carModelPreviewURLShow.setText(car.getPrevireUrl());
        this.carModelPreviewURLShow.setEditable(false);
        this.carModelThumnailShow.setText(car.getThumbnail());
        this.carModelThumnailShow.setEditable(false);
        this.detailPanel.setVisible(true);
    }
    
    @Override
    public void addCar(Cars car) {
        ImageIcon icon = new ImageIcon(car.getThumbnail());
        ((DefaultTableModel)this.outputTable.getModel()).addRow(new Object[]{car.getCarId(), car.getName(), car.getMake()});
    }
    
    @Override
    public void addCars(List<Cars> car) {
        for(Cars c : car) {
            ImageIcon icon = new ImageIcon(c.getThumbnail());
            ((DefaultTableModel)this.outputTable.getModel()).addRow(new Object[]{c.getCarId(), c.getName(), c.getMake()});
        }
    }
    
    @Override
    public void addCars(Set<Cars> car) {
        for(Cars c : car) {
            ImageIcon icon = new ImageIcon(c.getThumbnail());
            ((DefaultTableModel)this.outputTable.getModel()).addRow(new Object[]{c.getCarId(), c.getName(), c.getMake()});
        }
    }
    
    @Override
    public int getCarNo() {
        if (this.modelNo.isSelected()) {
            try {
                return Integer.parseInt(this.keyTextField.getText());
            } catch (Exception e) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Override
    public void clearInput() {
        this.keyTextField.setText("");
        this.modelNo.setSelected(true);
        this.modelName.setSelected(false);
        this.modelMake.setSelected(false);
        this.modelType.setSelected(false);
        this.detailPanel.setVisible(false);
        this.keyPanel.setVisible(true);
        this.typePanel.setVisible(false);
    }
    
    @Override
    public void clearTab() {
        int numberOfRow = this.outputTable.getModel().getRowCount();
        
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.outputTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
    }

    @Override
    public JTable getOutputTable() {
        return outputTable;
    }
    
    @Override
    public String getInputText() {
        return this.keyTextField.getText();
    }
     
    @Override
    public boolean isCarSelected() {
        return (this.outputTable.getSelectedRow() >= 0);
    }
   
    @Override
    public int getSelectedCar() {
        int index = this.outputTable.getSelectedRow();
        String carId = this.outputTable.getValueAt(index, 0).toString();
        return Integer.parseInt(carId);
    }

    @Override
    public JPanel getTypePanel() {
        return typePanel;
    }

    @Override
    public JPanel getKeyPanel() {
        return keyPanel;
    }

    @Override
    public JButton getSearchButton2() {
        return searchButton2;
    }
    
    @Override
    public String getSelectedType() {
        return (String)this.typeCombo.getSelectedItem();
    }
    
}
