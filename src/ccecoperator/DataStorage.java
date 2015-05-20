/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Lokes
 */
public class DataStorage {
    private static DataStorage myDataStorage;
    private StringProperty previousScene = new SimpleStringProperty();

    private String employeeID;
    private String password;
    
    private DataStorage() {
    }

    public static DataStorage getInstance() {
        if (myDataStorage == null) {
            myDataStorage = new DataStorage();
        }

        return myDataStorage;
    }

    
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getPreviousScene() {
        return previousScene.get();
    }

    public void setPreviousScene(String previousScene) {
        this.previousScene.set(previousScene);
    }

    public StringProperty previousSceneProperty() {
        return previousScene;
    }

   
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }
}

    

