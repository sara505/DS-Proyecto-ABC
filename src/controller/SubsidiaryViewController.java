/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import getset.SubsidiaryVariables;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sql.SubsidiaryCrud;


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
    private Button btActualizar;

    @FXML
    private Button btBuscar;

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
    void btActualizarOnAction(ActionEvent event) {
        LocalDate date = dpFechaFundacion.getValue();
        crud.update(Integer.parseInt(txtID.getText()), txtNombre.getText(), txtDireccion.getText(), date);
    }
    
    
    @FXML
    void btBuscarOnAction(ActionEvent event) {
       
        
       var = crud.read(Integer.parseInt(txtID.getText()));
       
       if(var.getId_sede() != -1){
           txtID.setText(Integer.toString(var.getId_sede()));
       txtNombre.setText(var.getNombre_sede());
       dpFechaFundacion.setValue(var.getFechaFundacion_sede());
       txtDireccion.setText(var.getDireccion_sede());
       }
       else
       {
           limpiarCampos();
       }
       
    }
    

    @FXML
    void btCancelarOnAction(ActionEvent event) {
        limpiarCampos();
    }
    
      
    
    @FXML
    void btGuardarOnAction(ActionEvent event) {  
        LocalDate date = dpFechaFundacion.getValue();
        crud.create(Integer.parseInt(txtID.getText()), txtNombre.getText(), txtDireccion.getText(), date);
        
    }

    public void limpiarCampos(){
       txtID.setText("");
       txtNombre.setText("");
       txtDireccion.setText("");
       dpFechaFundacion.getEditor().clear();
         
   }
       
}



