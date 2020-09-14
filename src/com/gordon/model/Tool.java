package com.gordon.model;

/**
 * Enum for Tools
 *
 * @author Gordon Price
 */
public enum Tool {
    /** Tool Data based on unique tool-specific code **/
    LADW("Ladder", "Werner", "LADW"), CHNS("Chainsaw", "Stihl", "CHNS"),
    JAKR("Jackhammer", "Rigid", "JAKR"), JAKD("Jackhammer", "DeWalt", "JAKD");


    private String type;
    private String brand;
    /** Unique tool-specific code **/
    private String code;

    /**
     * Constructor for Tool
     *
     * @param type
     * @param brand
     * @param code
     */
    private Tool(String type, String brand, String code) {
        this.type = type;
        this.brand = brand;
        this.code = code;
    }

    /** Tool Type **/
    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }

    /** Brand **/
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /** Code **/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the Tool object depending on the code
     *
     * @param code Code of the tool to be returned
     * @return Tool object
     */
    public static Tool getTool(String code){
        switch (code) {
            case "LADW":
                return LADW;
            case "CHNS":
                return CHNS;
            case "JAKR":
                return JAKR;
            case "JAKD":
                return JAKD;
            default:
                return null;
        }
    }
}
