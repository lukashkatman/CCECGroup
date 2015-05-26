/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lokes
 */
public class SettingsController extends ControllerClass {

    @Override
    public void initialize(URL url, ResourceBundle rb) { // TODO }

    }
    /* if (!userNameExist) { //create the user name and save
     Files.write(pathClient, createTemp, StandardOpenOption.APPEND);
     addToStorage(textUserClient.getText());
     goToScene(event, "FXMLDocument.fxml"); */

    @FXML
    private TextField employeeID;
    @FXML
    TextField textRemove;
    @FXML
    private TextField password;
    @FXML
    private TextField passwordAgain;
    @FXML
    private Label wrongPassword;
    @FXML
    private TextArea viewUsers;
    private Path path = Paths.get("userOfEmployee.txt");
    private List<String> users;
    private ArrayList<String> userClient = new ArrayList<>();

    private ArrayList<String> passClient = new ArrayList<>();

    Path pathClient = Paths.get("userOfEmployee.txt");

    @FXML
    private void handleButtonCreateAction(ActionEvent event) {
        createUser();

    }

    @FXML
    private void remove() throws IOException {
        int index = Integer.valueOf(textRemove.getText());
        if (index < 1 || (2 * index - 2) >= users.size()) {
            System.out.println("error out of bound");
        } else {
            users.remove(2 * index - 1);
            users.remove(2 * index - 2);
            Files.deleteIfExists(path);
            Files.write(path, users, StandardOpenOption.CREATE);
            showList();
        }

    }

    private void showList() {
        try {
            viewUsers.clear();
            // ArrayList<String> tempUsers = new ArrayList<>();
            //ArrayList<String> tempUserpw = new ArrayList<>();
            users = Files.readAllLines(path);
            String u;
            boolean ok = false;
            for (int i = 0, j = 0; i < users.size(); i++) {
                u = users.get(i);

                if (ok) {
                    viewUsers.appendText(u + "\n");
                    ok = false;
                } else {
                    j++;
                    viewUsers.appendText(j + " - " + u + "         ");
                    ok = true;
                }
            }
            /* for (String u : users) {

             viewUsers.appendText(u + "\n");
             } */

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleButtonViewUsersAction(ActionEvent event) {
        showList();
    }

    @FXML
    private void handleButtonBackAction(ActionEvent event
    ) {
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
            ex.printStackTrace();
        }

    }
    
    private void createUser(){
        
        double bod = Double.valueOf(employeeID.getText());
        
        try {
            Path path = Paths.get("userOfEmployee.txt");
            
            
                 //gets text from the field BALANCE)
            if (!password.getText().equals(passwordAgain.getText())) {
                
                wrongPassword.setText("PASSWORDS DOES NOT MATCH");
            
            } else{

                ArrayList<String> userss = new ArrayList<>();
                ArrayList<String> userpw = new ArrayList<>();

                userss.add(employeeID.getText());
                userpw.add(password.getText());
                Files.write(path, userss, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                Files.write(path, userpw, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                
                System.out.println("You pressed Create user!");
                wrongPassword.setText("");
                employeeID.clear();
                password.clear();
                passwordAgain.clear();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
}
