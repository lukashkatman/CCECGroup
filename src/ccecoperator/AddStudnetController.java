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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    
    @FXML
    private Label StudentID;
    
    @FXML
    private Label Studentname;
    
    @FXML
    private Label Phonenumber;
    
    @FXML
    private Label Address;
    
    @FXML
    private Label Email;
    
    @FXML
    private Label Admitted;        
            
    @FXML
    private Label UniversityID;
    
    @FXML
    private Label CountryID;        
            
    @FXML
    private Label EmployeeID;
    
     @FXML
    private Label helpinfo;
    
    @FXML
    private Label IDCountryinfo;
    
    @FXML
    private Label sv;
     
    @FXML
    private Label dk;
      
    @FXML
    private Label no;  
    
    @FXML
    private Label fi;
    
    @FXML
    private Label empid;
    
    @FXML
    private Label peter;
    
    @FXML
    private Label jessica;
    
    @FXML
    private Label micheal;
    
    @FXML
    private Label unid;
    
    @FXML
    private Label hkr;
    
    @FXML
    private Label mu;
    
    @FXML
    private Label cum;
    
    @FXML
    private Label cud;
    
    @FXML
    private Label nu;
    
    @FXML
    private Label ou;
    
    @FXML
    private Label hp;
    
    
    
    
    
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
    
    @FXML
    private void handleButtonBackAction(ActionEvent event) {
        try {
            // An alternative to getting the Stage from a Node declared in the scene is
            // to ask the button pressed what scene it belongs to.
            Node node = (Node) event.getSource();       
            Stage stage = (Stage) node.getScene().getWindow(); 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Students.fxml"));  
            Parent root = loader.load();

            Scene scene = new Scene(root);      
            stage.setScene(scene);              
            stage.show();                       

            System.out.println("Gatting you back to previous page!");
        } catch (Exception ex) {
        }   
    
    
    }
    
     @FXML 
    private void handleButtonHelpAction(ActionEvent event) {

        try {
            
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Help.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("You clicked Help!");
        } catch (Exception ex) {
        

        System.out.println("ERROR!");
        }
    }
    
    @FXML 
    private void handleButtonGobackAction(ActionEvent event) {

        try {
            
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddStudent.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("You clicked Back!");
        } catch (Exception ex) {
        

        System.out.println("ERROR!");
        }
    }
    
    
   
       
}
