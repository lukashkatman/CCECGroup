/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Lokes
 */
public class StudentProperty {
    private final SimpleIntegerProperty idStudent;
    private final SimpleStringProperty studentName;
    private final SimpleStringProperty phnumberStudent;
    private final SimpleStringProperty address;
    private final SimpleStringProperty email;
    private final SimpleIntegerProperty admitted;
    private final SimpleIntegerProperty idUniversity;
    private final SimpleIntegerProperty idCountry;
    private final SimpleIntegerProperty idEmployee;
    
    
public StudentProperty(int idStudent, String studentName, String phnumberStudent, String address, String email, Integer admitted, Integer idUniversity, Integer idCountry, Integer idEmployee) {
    this.idStudent = new SimpleIntegerProperty(idStudent);
    this.studentName = new SimpleStringProperty(studentName);
    this.phnumberStudent = new SimpleStringProperty(phnumberStudent);
    this.address = new SimpleStringProperty(address);
    this.email = new SimpleStringProperty(email);
    this.admitted = new SimpleIntegerProperty(admitted);
    this.idUniversity = new SimpleIntegerProperty(idUniversity);
    this.idCountry = new SimpleIntegerProperty(idCountry);
    this.idEmployee = new SimpleIntegerProperty(idEmployee);
}

public SimpleIntegerProperty getIdStudent(){
    return idStudent;
}

public SimpleStringProperty getStudentName() {
    return studentName;
}

public SimpleStringProperty getPhnumberStudent() {
    return phnumberStudent;
}

public SimpleStringProperty getAddress() {
    return address;
}

public SimpleStringProperty getEmail() {
    return email;
}

public SimpleIntegerProperty getAdmitted() {
    return admitted;
}

public SimpleIntegerProperty getIdUniversity() {
    return idUniversity;
}

public SimpleIntegerProperty getIdCountry ()  {
    return idCountry;
}

public SimpleIntegerProperty getIdEmployee() {
    return idEmployee;
}
}

   
    

