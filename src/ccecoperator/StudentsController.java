/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lokes
 */
public class StudentsController extends ControllerClass {

   
       
    
    @FXML
    private TableView<StudentProperty> studentsTable;
    
    @FXML
    private TableColumn<StudentProperty, Integer> idStudent;
    
    @FXML
    private TableColumn<StudentProperty, String> studentName;
    
    @FXML
    private TableColumn<StudentProperty, String> phnumberStudent;
    
    @FXML
    private TableColumn<StudentProperty, String> address;
    
    @FXML
    private TableColumn<StudentProperty, String> email;
    
    @FXML
    private TableColumn<StudentProperty, Integer> admitted;
    
    @FXML
    private TableColumn<StudentProperty, Integer> idUniversity;
    
    @FXML
    private TableColumn<StudentProperty, Integer> idCountry;
    
    @FXML
    private TableColumn<StudentProperty, Integer> idEmployee;
    
    @FXML
    private TextField removeStudent;
    
    private ObservableList<StudentProperty> allStudents;
    
    
    
    
    @FXML
    private void handleButtonDelStudentAction (ActionEvent event) {
        try {
            StudentQueries sq = new StudentQueries();
            
            sq.delStudent(Integer.valueOf(removeStudent.getText())); //get this value from text field
        }catch(Exception ex){
            System.out.println("Something went wrong!");
            
        }
    }
    
    @FXML
    private void handleButtonViewStudentAction (ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/ccec?user=root&password=root";
            try (Connection c = DriverManager.getConnection(URL)) {
                Statement st = c.createStatement();
                ResultSet rs  = st.executeQuery("SELECT * FROM student ");
                {
                ResultSetMetaData metaData = rs.getMetaData();
                int numberOfColumns = metaData.getColumnCount();
                
                System.out.printf("Countries Table of CCEC Database:%n%n");
                
                for (int i=1; i<= numberOfColumns; i++)
                    System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.println();
                
                allStudents = FXCollections.observableArrayList();
                
                while (rs.next())
                {
                    for (int i=1; i <= numberOfColumns; i++)
                        System.out.printf("%-8s\t", rs.getObject(i));
                    System.out.println();
                    
                    allStudents.add(new StudentProperty(rs.getInt("idStudent"), rs.getString("studentName"), rs.getString("phnumberStudent"), rs.getString("address"), rs.getString("email"), rs.getInt("admitted"), rs.getInt("idUniversity"), rs.getInt("idCountry"), rs.getInt("idEmployee")));
                }
                
                fillTable();
                
            }
                /*while(rs.next()){
                    int nbr = rs.getInt("visaCharge");
                    String name = rs.getString("countryName");
                    System.out.println("Country Name: " + name + " \n and our service charge in SEK  " + nbr + "\n\n");
                }*/
               
                
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
    
    
    }
    
    @FXML
    private void handleButtonBackAction(ActionEvent event) {
        try {
            // An alternative to getting the Stage from a Node declared in the scene is
            // to ask the button pressed what scene it belongs to.
            Node node = (Node) event.getSource();       
            Stage stage = (Stage) node.getScene().getWindow(); 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2mainpage.fxml"));  
            Parent root = loader.load();

            Scene scene = new Scene(root);      
            stage.setScene(scene);              
            stage.show();                       

            System.out.println("Gatting you back to previous page!");
        } catch (Exception ex) {
        }
    
    
    
    
    }
    
     /*@FXML
    private void handleButtonAddStudentAction (ActionEvent event) {
    try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/ccec?user=root&password=root";
            try (Connection c = DriverManager.getConnection(URL)) {
                Statement st = c.createStatement();
                String sql = ("INSERT INTO student(idStudent,studentName,phnumberStudent,address,email,admitted,idUniversity,idCountry,idEmployee)" + "VALUES(19,'Loky', 000222, 'malmö, 'loke@yahoo.com', 1 ,91 ,101 , 51)");
                st.executeUpdate(sql);
                
            }
            
    }
            catch (Exception ex){
                System.out.println("Error!");
            }
    }
       */
    @FXML
    private void handleButtonAddStudentAction(ActionEvent event) {
        try {
            // An alternative to getting the Stage from a Node declared in the scene is
            // to ask the button pressed what scene it belongs to.
            Node node = (Node) event.getSource();       
            Stage stage = (Stage) node.getScene().getWindow(); 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddStudent.fxml"));  
            Parent root = loader.load();

            Scene scene = new Scene(root);      
            stage.setScene(scene);              
            stage.show();                       

            System.out.println("Gatting you to next page where you can add new student!");
        } catch (Exception ex) {
        }
    
    
    
    
    }
                
     @FXML
    private void handleButtonLogOutAction(ActionEvent event) {

        try {
            // An alternative to getting the Stage from a Node declared in the scene is
            // to ask the button pressed what scene it belongs to.
            Node node = (Node) event.getSource();       
            Stage stage = (Stage) node.getScene().getWindow(); 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1LogIn.fxml"));  
            Parent root = loader.load();

            Scene scene = new Scene(root);      
            stage.setScene(scene);              
            stage.show();                       

            System.out.println("You clicked LOG OUT!");
        } catch (Exception ex) {
        }
    }
    
    private void fillTable() {
        idStudent.setCellValueFactory(CellData -> CellData.getValue().getIdStudent().asObject());
        studentName.setCellValueFactory(CellData -> CellData.getValue().getStudentName());
        phnumberStudent.setCellValueFactory(CellData -> CellData.getValue().getPhnumberStudent());
        address.setCellValueFactory(CellData -> CellData.getValue().getAddress());
        email.setCellValueFactory(CellData -> CellData.getValue().getEmail());
        admitted.setCellValueFactory(CellData -> CellData.getValue().getAdmitted().asObject());
        idUniversity.setCellValueFactory(CellData -> CellData.getValue().getIdUniversity().asObject());
        idCountry.setCellValueFactory(CellData -> CellData.getValue().getIdCountry().asObject());
        idEmployee.setCellValueFactory(CellData -> CellData.getValue().getIdEmployee().asObject());
        
        studentsTable.setItems(allStudents);
    }
}


