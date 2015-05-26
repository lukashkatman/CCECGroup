/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package ccecoperator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Lokes
 
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

 */
package ccecoperator;

public class DataStorage {

    private static DataStorage myDataStorage;

    /**
     * @return the myDataStorage
     */
    public static DataStorage getMyDataStorage() {
        return myDataStorage;
    }

    /**
     * @param aMyDataStorage the myDataStorage to set
     */
    public static void setMyDataStorage(DataStorage aMyDataStorage) {
        myDataStorage = aMyDataStorage;
    }
    private boolean isAdmin = false;

    private int employee;
    private String employeePassw;
    
     

    private DataStorage() {
    }

    public static DataStorage getInstance() {
        if (getMyDataStorage() == null) {
            setMyDataStorage(new DataStorage());
        }

        return getMyDataStorage();
    }

    /**
     * @return the clientName
     */
    public boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the employee
     */
    public int getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(int employee) {
        this.employee = employee;
    }

    /**
     * @return the employeePassw
     */
    public String getEmployeePassw() {
        return employeePassw;
    }

    /**
     * @param employeePassw the employeePassw to set
     */
    public void setEmployeePassw(String employeePassw) {
        this.employeePassw = employeePassw;
    }

}


