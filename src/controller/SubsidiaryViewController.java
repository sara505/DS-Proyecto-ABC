/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import getset.SubsidiaryVariables;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import sql.SubsidiaryCrud;
import sql.sqlConnection;


/**
 * FXML Controller class
 *
 * @author Sara Eraso
 */
public class SubsidiaryViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }  

       
    SubsidiaryCrud crud = new SubsidiaryCrud();
    SubsidiaryVariables var = new SubsidiaryVariables();
    
    @FXML
    private Button btCancelar;

    @FXML
    private Button btGuardar;

    @FXML
    private DatePicker dpFechaFundacion;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNombre;
    
    @FXML
    private TextField txtDate;

    
    @FXML
    void btActualizarOnAction(ActionEvent event) {
        crud.update(Integer.parseInt(txtID.getText()), txtNombre.getText(), txtDireccion.getText(), Date.from(dpFechaFundacion.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));

    }
    
    
    @FXML
    void btBuscarOnAction(ActionEvent event) {
        
       var = crud.read(Integer.parseInt(txtID.getText()));
       
       txtID.setText(Integer.toString(var.getId_sede()));
       txtNombre.setText(var.getNombre_sede());
       txtDate.setText(var.getFechaFundacion_sede());
       //txtDate.setText(var.getFechaFundacion_sede().toInstant().atOffset(ZoneOffset.UTC).format( DateTimeFormatter.ofPattern("dd-MM-yyyy")));
       //dpFechaFundacion.setValue(var.getFechaFundacion_sede().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
       txtDireccion.setText(var.getDireccion_sede());
    }
    


    @FXML
    void btCancelarOnAction(ActionEvent event) {
        limpiarCampos();
    }
    
    public void limpiarCampos(){
       txtID.setText("");
       txtNombre.setText("");
       txtDireccion.setText("");
       txtDate.setText("");
       dpFechaFundacion.getEditor().clear();
       
       
   }
    
    
    
    @FXML
    void btGuardarOnAction(ActionEvent event) {  
        
        //crud.create(Integer.parseInt(txtID.getText()), txtNombre.getText(),txtDireccion.getText(),Date.from(dpFechaFundacion.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant() ));
        crud.create(Integer.parseInt(txtID.getText()), txtNombre.getText(),txtDireccion.getText(),dpFechaFundacion.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }

    
    
}
