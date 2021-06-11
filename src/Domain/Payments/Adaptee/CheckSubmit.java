/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Payments.Adaptee;

/**
 *
 * @author boud-
 */
public class CheckSubmit implements SubmitAdaptee{

    @Override
    public String submit() {
        return "Thank you, your Check account is valid";
    }
    public static final CheckSubmit INSTANCE = new CheckSubmit();
}
