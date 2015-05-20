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
public class UniversityProperty {
    
    private final SimpleIntegerProperty idUniversity;
    private final SimpleStringProperty universityName;
    private final SimpleStringProperty faculty;
    private final SimpleDoubleProperty fee;
    private final SimpleStringProperty dateOfEnrollment;
    private final SimpleIntegerProperty idCountry;
    
    public UniversityProperty (int idUniversity, String universityName, String faculty, Double fee, String dateOfEnrollment, int idCountry){
        this.idUniversity = new SimpleIntegerProperty(idUniversity);
        this.universityName = new SimpleStringProperty(universityName);
        this.faculty = new SimpleStringProperty(faculty);
        this.fee = new SimpleDoubleProperty(fee);
        this.dateOfEnrollment = new SimpleStringProperty(dateOfEnrollment);
        this.idCountry = new SimpleIntegerProperty(idCountry);
    }
    
    public SimpleIntegerProperty getIdUniversity(){
        return idUniversity;
    }
    
    public SimpleStringProperty getUniversityName() {
        return universityName;
    }
    
    public SimpleStringProperty getFaculty() {
        return faculty;
    }
    
    public SimpleDoubleProperty getFee() {
        return fee;
    } 
    
    public SimpleStringProperty getDateOfEnrollment() {
        return dateOfEnrollment;
    }
    
    public SimpleIntegerProperty getIdCountry() {
        return idCountry;
    }
    
    
    
    
}
