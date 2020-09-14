package com.gordon;

import com.gordon.model.RentalAgreement;
import com.gordon.model.Tool;
import com.gordon.model.ToolCharges;
import com.gordon.service.CalendarService;
import com.gordon.service.NumService;
import java.util.Date;

/**
 * Model for RentalAgreement information
 *
 * @author Gordon Price
 */
public class Checkout {
    /** Amount of days the tool is being rented for **/
    private String toolCode;
    /** Date the tool was checked out on **/
    private Date checkoutDate;
    /** Amount of days the tool is being rented for **/
    private int rentalDays;
    /** Percent of discount to be applied **/
    private double discountPercent;


    /**
     * Constructor for Checkout
     *
     * @param toolCode
     * @param checkoutDate
     * @param rentalDays
     * @param discountPercent
     */
    public Checkout(String toolCode, Date checkoutDate, int rentalDays, int discountPercent) {
        this.toolCode = toolCode;
        this.checkoutDate = checkoutDate;
        this.rentalDays = rentalDays;
        this.discountPercent = discountPercent;
    }

    /**
     *Generates a rental agreement instance with tool, toolcharges, checkout, and rental agreement data
     *
     * @return RentalAgreement object
     *
     * @throws IllegalArgumentException Rental days are less than 1
     * @throws IllegalArgumentException Discount percent is lower than 0 or greater than 100
     */
    public RentalAgreement generateRentalAgreement() throws IllegalArgumentException {
        int rentalDays = this.getRentalDays();
        double discountPercent = this.getDiscountPercent();
        if(rentalDays < 1){
            throw new IllegalArgumentException("Please enter an amount of rental days greater than 1. You entered: " + rentalDays);
        }else if(discountPercent < 0 || discountPercent > 100){
            throw new IllegalArgumentException("Please enter a discount percent thats greater than 0 and less than 100. You entered: " + String.format("%.0f",discountPercent) + "%");
        }
        Tool tool = Tool.getTool(this.getToolCode());//
        ToolCharges toolCharge = ToolCharges.getCharges(tool.getType());
        int chargeableDays = CalendarService.calculateChargeableDays(this.checkoutDate, rentalDays, toolCharge);
        /** Initialize Rental Agreement Values **/
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setTool(tool);
        rentalAgreement.setCheckout(this);
        rentalAgreement.setDueDate(CalendarService.calculateDueDate(checkoutDate, rentalDays));
        rentalAgreement.setDailyRentalCharge(toolCharge.getDailyCharge());
        rentalAgreement.setChargeableDays(chargeableDays);
        rentalAgreement.setPreDiscountCharge(NumService.roundHalfUpToCents(chargeableDays * rentalAgreement.getDailyRentalCharge()));
        rentalAgreement.setDiscountAmount(NumService.roundHalfUpToCents(this.discountPercent / 100 *  rentalAgreement.getPreDiscountCharge()));
        rentalAgreement.setFinalCharge(NumService.roundHalfUpToCents(rentalAgreement.getPreDiscountCharge() - rentalAgreement.getDiscountAmount()));
        return rentalAgreement;
    }

    /** Tool Code **/
    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    /** Rental Days **/
    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    /** Discount Percent **/
    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    /** Checkout Date **/
    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
