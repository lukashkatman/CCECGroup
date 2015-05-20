/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lokes
 */
public class AddStudnetController extends ControllerClass {

    @FXML
    private TextField addidStudent;
    
    @FXML
    private TextField addstudentName;
    
    @FXML
    private TextField addphnumberStudent;
    
    @FXML
    private TextField addaddress;
    
    @FXML
    private TextField addemail;
    
    @FXML
    private TextField addadmitted;
    
    @FXML
    private TextField addidUniversity;
    
    @FXML
    private TextField addidCountry;
    
    @FXML
    private TextField addidEmployee;
    
    
    StudentQueries studentQueries = new StudentQueries();
        
    @FXML
    private void handleButtonAddStudentAction (ActionEvent event) {
        try{
            
            Student s = new Student(Integer.valueOf(addidStudent.getText()), addstudentName.getText(), addphnumberStudent.getText(), addaddress.getText(), addemail.getText(), Integer.valueOf(addadmitted.getText()), Integer.valueOf(addidUniversity.getText()), Integer.valueOf(addidCountry.getText()), Integer.valueOf(addidEmployee.getText()));
            // int result = studentQueries.addStudent(addidStudent.getText(), addstudentName.getText(), addphnumberStudent.getText(), addaddress.getText(), addemail.getText(),addadmitted.getText(), addidUniversity.getText(), addidCountry.getText(), addidEmployee.getText());
            if (studentQueries.insertStudent(s)){
                addidStudent.clear();
                addstudentName.clear();
                addphnumberStudent.clear();
                addaddress.clear();
                addemail.clear();
                addadmitted.clear();
                addidUniversity.clear();
                addidCountry.clear();
                addidEmployee.clear();
                
                
            }
        }
        catch (Exception e)
        {
            System.out.println("Error" + e);
        }
    }
}
