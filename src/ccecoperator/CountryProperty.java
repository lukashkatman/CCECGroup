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
public class CountryProperty {
    
    private final SimpleIntegerProperty idCountry;
    private final SimpleStringProperty countryName;
    private final SimpleStringProperty currency;
    private final SimpleStringProperty language;
    private final SimpleDoubleProperty visaCharge;
    
    public CountryProperty(int idCountry, String countryName, String currency, String language, Double visaCharge) {
        this.idCountry = new SimpleIntegerProperty(idCountry);
        this.countryName = new SimpleStringProperty(countryName);
        this.currency = new SimpleStringProperty(currency);
        this.language = new SimpleStringProperty(language);
        this.visaCharge = new SimpleDoubleProperty(visaCharge);
        
    }
    
    public SimpleIntegerProperty getIdCountry() {
        return idCountry;
    }
    
    public SimpleStringProperty getCountryName() {
        return countryName;
    }
    
    public SimpleStringProperty getCurrency() {
        return currency;
    }
    
    public SimpleStringProperty getLanguage() {
        return language;
    }
    
    public SimpleDoubleProperty getVisaCharge() {
        return visaCharge;
    }
}
   
