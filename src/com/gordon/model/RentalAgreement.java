package com.gordon.model;

import com.gordon.Checkout;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Model for RentalAgreement information
 *
 * @author Gordon Price
 */
public class RentalAgreement {
    private Tool tool;//
    private Checkout checkout;//
    /** Date the tool is to be returned **/
    private Date dueDate;
    private double dailyRentalCharge;//
    /** Amount of days we can charge for the tool **/
    private int chargeableDays;
    private double preDiscountCharge;
    private double discountAmount;
    private double finalCharge;

    /** Tool **/
    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    /** Checkout **/
    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    /** Due Date **/
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /** Daily Rental Charge **/
    public double getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public void setDailyRentalCharge(double dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    /** Chargeable Days **/
    public int getChargeableDays() {
        return chargeableDays;
    }

    public void setChargeableDays(int chargeableDays) {
        this.chargeableDays = chargeableDays;
    }

    /** Pre-discount Charge **/
    public double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(double preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    /** Discount Amount **/
    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    /** Final Charge **/
    public double getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(double finalCharge) {
        this.finalCharge = finalCharge;
    }

    /** Print out rental agreement values to console **/
    public void printRentalAgreement(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        System.out.println("Tool code: " + this.tool.getCode());
        System.out.println("Tool type: " + this.tool.getType());
        System.out.println("Tool brand: " + this.tool.getBrand());
        System.out.println("Rental days: " + this.checkout.getRentalDays());
        System.out.println("Check out date: " + formatter.format(this.checkout.getCheckoutDate()));
        System.out.println("Due date: " + formatter.format(this.dueDate));
        System.out.println("Daily rental charge: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(this.dailyRentalCharge));
        System.out.println("Chargeable days: " + this.chargeableDays);
        System.out.println("Pre-discount charge: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(this.preDiscountCharge));
        System.out.println("Discount percent: " + String.format("%.0f", this.checkout.getDiscountPercent()) + "%");
        System.out.println("Discount amount: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(this.discountAmount));
        System.out.println("Final Charge: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(this.finalCharge));
    }
}
