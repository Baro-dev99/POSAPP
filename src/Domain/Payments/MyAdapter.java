/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Payments;

import Domain.Payments.Adaptee.CheckSubmit;
import Domain.Payments.Adaptee.CashSubmit;
import Domain.Payments.Adaptee.CreditCardSubmit;
import Domain.Payments.Target.*;
import javax.swing.JOptionPane;
import Domain.Payments.Adaptee.SubmitAdaptee;

/**
 *
 * @author boud-
 */
public class MyAdapter implements PaymentADAPTER {

    private final SubmitAdaptee adapter;

    public MyAdapter(SubmitAdaptee adapter) {
        this.adapter = adapter;
    }

    @Override
    public String proceed() {
        if (adapter instanceof CashSubmit) {
            return CashPayment.INSTANCE.proceed() + "\n\n" + CashSubmit.INSTANCE.submit();
        } else if (adapter instanceof CreditCardSubmit) {
            return CreditCardPayment.INSTANCE.proceed() + "\n\n" + CreditCardSubmit.INSTANCE.submit();
        }
        return CheckPayment.INSTANCE.proceed() + "\n\n" + CheckSubmit.INSTANCE.submit();
    }

    public void askPay() {
        MyAdapter adap;
        String[] Payment = {"Cash", "CreditCard", "Check"};
        int optionChoosed = JOptionPane.showOptionDialog(null, "Choose your payment method !", "PAYMENT METHOD",
                0, JOptionPane.WARNING_MESSAGE, null, Payment, Payment[1]);

        String pay = "";
        if (Payment[optionChoosed].equals(Payment[0])) {
            adap = new MyAdapter(new CashSubmit());
        } else if (Payment[optionChoosed].equals(Payment[1])) {
            adap = new MyAdapter(new CreditCardSubmit());
        } else {
            adap = new MyAdapter(new CheckSubmit());
        }
        pay = adap.proceed();
        JOptionPane.showMessageDialog(null, pay);
    }

    // just for test
//    public static void main(String[] args) {
//
//        MyAdapter adap;
//        String[] Payment = {"Cash", "CreditCard", "Check"};
//        int optionChoosed = JOptionPane.showOptionDialog(null, "Choose your payment method !", "PAYMENT METHOD",
//                0, JOptionPane.WARNING_MESSAGE, null, Payment, Payment[1]);
//
//        String pay = "";
//        if (Payment[optionChoosed].equals(Payment[0])) {
//            adap = new MyAdapter(new CashSubmit());
//        } else if (Payment[optionChoosed].equals(Payment[1])) {
//            adap = new MyAdapter(new CreditCardSubmit());
//        } else {
//            adap = new MyAdapter(new CheckSubmit());
//        }
//        pay = adap.proceed();
//        JOptionPane.showMessageDialog(null, pay);
//
//    }
    
}
