package com.gordon.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Worker class for formatting Numbers
 *
 * @author Gordon Price
 */
public class NumService {
    private final static int PLACES_TO_ROUND = 2;

    /**
     * Rounds half up to the cents
     *
     * @param value the value needing to be rounded
     * @return double rounded value
     */
    public static double roundHalfUpToCents(double value){
        BigDecimal numBigDecimal = new BigDecimal(value).setScale(PLACES_TO_ROUND, RoundingMode.HALF_UP);
        return numBigDecimal.doubleValue();
    }
}
