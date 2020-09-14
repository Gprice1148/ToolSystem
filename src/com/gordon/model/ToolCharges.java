package com.gordon.model;

/**
 * Enum for Charges
 *
 * @author Gordon Price
 */
public enum ToolCharges {
    /** Charge Data based on tool type **/
    LADDER("Ladder", 1.99, true, true, false),
    CHAINSAW("Chainsaw", 1.49, true, false, true),
    JACKHAMMER("Jackhammer", 2.99, true, false, false);

    private String toolType;
    private double dailyCharge;
    /** Do we charge for the tool on Weekdays **/
    private boolean isWeekDayCharge;
    /** Do we charge for the tool on Weekends **/
    private boolean isWeekendCharge;
    /** Do we charge for the tool on Holidays **/
    private boolean isHolidayCharge;

    /**
     * Constructor for Charges
     *
     * @param toolType
     * @param dailyCharge
     * @param isWeekDayCharge
     * @param isWeekendCharge
     * @param isHolidayCharge
     */
    private ToolCharges(String toolType, double dailyCharge, boolean isWeekDayCharge, boolean isWeekendCharge, boolean isHolidayCharge) {
        this.toolType = toolType;
        this.dailyCharge = dailyCharge;
        this.isWeekDayCharge = isWeekDayCharge;
        this.isWeekendCharge = isWeekendCharge;
        this.isHolidayCharge = isHolidayCharge;
    }

    /** Tool Type **/
    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    /** Daily Charge **/
    public double getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(double dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    /** Weekday Charge **/
    public boolean isWeekDayCharge() { return isWeekDayCharge; }

    public void setWeekDayCharge(boolean weekDayCharge) {
        isWeekDayCharge = weekDayCharge;
    }

    /** Weekend Charge **/
    public boolean isWeekendCharge() {
        return isWeekendCharge;
    }

    public void setWeekendCharge(boolean weekendCharge) {
        isWeekendCharge = weekendCharge;
    }

    /** Holiday Charge **/
    public boolean isHolidayCharge() {
        return isHolidayCharge;
    }

    public void setHolidayCharge(boolean holidayCharge) {
        isHolidayCharge = holidayCharge;
    }

    /**
     * Gets the Charges object depending on the type
     *
     * @param type Type of the tool to be returned
     * @return ToolCharges object
     */
    public static ToolCharges getCharges(String type){
        switch (type) {
            case "Ladder":
                return LADDER;
            case "Chainsaw":
                return CHAINSAW;
            case "Jackhammer":
                return JACKHAMMER;
            default:
                return null;
        }
    }
}
