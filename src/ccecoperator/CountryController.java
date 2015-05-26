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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lokes
 */
public class CountryController extends ControllerClass {

   @FXML
   private TableView<CountryProperty> countryTable;
   
   @FXML
    private TableColumn<CountryProperty, Integer> idCountry;
   
   @FXML
   private TableColumn<CountryProperty, String> countryName;
   
   @FXML
   private TableColumn<CountryProperty, String> currency;
   
   @FXML
   private TableColumn<CountryProperty, String> language;
   
   @FXML
   private TableColumn<CountryProperty, Double> visaCharge;
   
   private ObservableList<CountryProperty> allCountry;
   
   
   
   
   
    
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
        }
        
       
        
        
        catch (Exception ex) {
        }
      
       
    }
    
    @FXML
    private void handleButtonCountriesAction (ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/ccec?user=root&password=root";
            try (Connection c = DriverManager.getConnection(URL)) {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM country");
                {
                ResultSetMetaData metaData = rs.getMetaData();
                int numberOfColumns = metaData.getColumnCount();
                
                System.out.printf("Countries Table of CCEC Database:%n%n");
                
                for (int i=1; i<= numberOfColumns; i++)
                    System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.println();
                
                allCountry = FXCollections.observableArrayList();
                
                while (rs.next())
                {
                    for (int i=1; i <= numberOfColumns; i++)
                        System.out.printf("%-8s\t", rs.getObject(i));
                    System.out.println();
                    
                    allCountry.add(new CountryProperty(rs.getInt("idCountry"), rs.getString("countryName"), rs.getString("currency"), rs.getString("language"), rs.getDouble("visaCharge")));
                    
                }
                
                fillTable();
            }
                /*while(rs.next()){
                    int nbr = rs.getInt("visaCharge");
                    String name = rs.getString("countryName");
                    System.out.println("Country Name: " + name + " \n and our service charge in SEK  " + nbr + "\n\n");
                } */
               
                
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
    
    } 
    
    private void fillTable() {
        idCountry.setCellValueFactory(CellData -> CellData.getValue().getIdCountry().asObject());
        countryName.setCellValueFactory(CellData -> CellData.getValue().getCountryName());
        currency.setCellValueFactory(CellData -> CellData.getValue().getCurrency());
        language.setCellValueFactory(CellData -> CellData.getValue().getLanguage());
        visaCharge.setCellValueFactory(CellData -> CellData.getValue().getVisaCharge().asObject());
        
        countryTable.setItems(allCountry);
    }
    
}
