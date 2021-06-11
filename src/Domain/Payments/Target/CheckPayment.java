/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Payments.Target;

/**
 *
 * @author boud-
 */
public class CheckPayment implements PaymentADAPTER {

    @Override
    public String proceed() {
        return "Your operation has been succeeded with Check Payment";
    }
    public static final CheckPayment INSTANCE = new CheckPayment();
}
