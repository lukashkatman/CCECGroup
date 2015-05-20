/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Lokes
 */
public class EmployeeProperty {
    
    private final SimpleIntegerProperty idEmployee;
    private final SimpleStringProperty nameEmployee;
    private final SimpleStringProperty telephoneEmployee;
    private final SimpleDoubleProperty salary;

public EmployeeProperty(int idEmployee, String nameEmployee, String telephoneEmployee, double salary) {
    this.idEmployee = new SimpleIntegerProperty(idEmployee);
    this.nameEmployee = new SimpleStringProperty(nameEmployee);
    this.telephoneEmployee = new SimpleStringProperty(telephoneEmployee);
    this.salary = new SimpleDoubleProperty(salary);
}

   

public SimpleIntegerProperty getIdEmployee() {
    return idEmployee;
}

public SimpleStringProperty getNameEmployee() {
    return nameEmployee;
}

public SimpleStringProperty getTelephoneEmployee() {
    return telephoneEmployee;
}

public SimpleDoubleProperty getSalary() {
    return salary;
}

}

