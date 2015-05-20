/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.io.Serializable;

/**
 *
 * @author Lokes
 */
public class Accounts implements Serializable {
    
    private String employeeID;
    private String password;

        public Accounts() {

        this("", "");

    }
        public Accounts(String employeeID, String password) {

        this.employeeID = employeeID;
        this.password = password;
        
    }

   
    public String getEmployeeID() {
        return employeeID;
    }

   
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    
    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }
}
    

