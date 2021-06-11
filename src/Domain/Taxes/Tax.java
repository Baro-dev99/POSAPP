/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Taxes;

/**
 *
 * @author boud-
 */
public class Tax {
    int idTax;
    double TaxPercentage;
    String CountryName;
    
    public int getIdTax() {
        return idTax;
    }

    public void setIdTax(int idTax) {
        this.idTax = idTax;
    }

    public double getTaxPercentage() {
        return TaxPercentage;
    }

    public void setTaxPercentage(double TaxPercentage) {
        this.TaxPercentage = TaxPercentage;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    @Override
    public String toString() {
        return "Tax{" + "idTax=" + idTax + ", TaxPercentage=" + TaxPercentage + ", CountryName=" + CountryName + '}';
    }
    
    
}
