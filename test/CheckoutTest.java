import com.gordon.Checkout;
import com.gordon.model.RentalAgreement;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;

/**
 *
 * Test class for testing CheckOut
 *
 * @author Gordon Price
 */
public class CheckoutTest {

    /**
     * Test case 1 per programming demo documentation
     *
     * @throws Exception IllegalArgumentException for validation discountPercent and rentalDays
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkoutTest1() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date checkoutDate = formatter.parse("07/02/20");
        Checkout checkout = new Checkout("JAKR", checkoutDate, 5, 101);
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
    }

    /**
     * Test case 2 per programming demo documentation
     *
     * @throws Exception IllegalArgumentException for validation discountPercent and rentalDays
     */
    @Test
    public void checkoutTest2() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date checkoutDate = formatter.parse("07/02/20");
        Checkout checkout = new Checkout("LADW", checkoutDate, 3, 10);
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        assertEquals("LADW", rentalAgreement.getTool().getCode());
        assertEquals("Ladder", rentalAgreement.getTool().getType());
        assertEquals("Werner", rentalAgreement.getTool().getBrand());
        assertEquals(3, rentalAgreement.getCheckout().getRentalDays());
        assertEquals(checkoutDate, rentalAgreement.getCheckout().getCheckoutDate());
        assertEquals("07/05/20",formatter.format(rentalAgreement.getDueDate()));
        assertEquals(1.99, rentalAgreement.getDailyRentalCharge(),0);
        assertEquals(2, rentalAgreement.getChargeableDays());
        assertEquals(3.98, rentalAgreement.getPreDiscountCharge(), 0);
        assertEquals(10, rentalAgreement.getCheckout().getDiscountPercent(),0);
        assertEquals(0.40, rentalAgreement.getDiscountAmount(), 0);
        assertEquals(3.58, rentalAgreement.getFinalCharge(), 0);
    }

    /**
     * Test case 3 per programming demo documentation
     *
     * @throws Exception IllegalArgumentException for validation discountPercent and rentalDays
     */
    @Test
    public void checkoutTest3() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date checkoutDate = formatter.parse("07/02/15");
        Checkout checkout = new Checkout("CHNS", checkoutDate, 5, 25);
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        assertEquals("CHNS", rentalAgreement.getTool().getCode());
        assertEquals("Chainsaw", rentalAgreement.getTool().getType());
        assertEquals("Stihl", rentalAgreement.getTool().getBrand());
        assertEquals(5, rentalAgreement.getCheckout().getRentalDays());
        assertEquals(checkoutDate, rentalAgreement.getCheckout().getCheckoutDate());
        assertEquals("07/07/15",formatter.format(rentalAgreement.getDueDate()));
        assertEquals(1.49, rentalAgreement.getDailyRentalCharge(),0);
        assertEquals(3, rentalAgreement.getChargeableDays());
        assertEquals(4.47, rentalAgreement.getPreDiscountCharge(), 0);
        assertEquals(25, rentalAgreement.getCheckout().getDiscountPercent(),0);
        assertEquals(1.12, rentalAgreement.getDiscountAmount(), 0);
        assertEquals(3.35, rentalAgreement.getFinalCharge(), 0);
    }

    /**
     * Test case 4 per programming demo documentation
     *
     * @throws Exception IllegalArgumentException for validation discountPercent and rentalDays
     */
    @Test
    public void checkoutTest4() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date checkoutDate = formatter.parse("09/03/15");
        Checkout checkout = new Checkout("JAKD", checkoutDate, 6, 0);
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        assertEquals("JAKD", rentalAgreement.getTool().getCode());
        assertEquals("Jackhammer", rentalAgreement.getTool().getType());
        assertEquals("DeWalt", rentalAgreement.getTool().getBrand());
        assertEquals(6, rentalAgreement.getCheckout().getRentalDays());
        assertEquals(checkoutDate, rentalAgreement.getCheckout().getCheckoutDate());
        assertEquals("09/09/15",formatter.format(rentalAgreement.getDueDate()));
        assertEquals(2.99, rentalAgreement.getDailyRentalCharge(),0);
        assertEquals(4, rentalAgreement.getChargeableDays());
        assertEquals(11.96, rentalAgreement.getPreDiscountCharge(), 0);
        assertEquals(0, rentalAgreement.getCheckout().getDiscountPercent(),0);
        assertEquals(0.00, rentalAgreement.getDiscountAmount(), 0);
        assertEquals(11.96, rentalAgreement.getFinalCharge(), 0);
    }

    /**
     * Test case 5 per programming demo documentation
     *
     * @throws Exception IllegalArgumentException for validation discountPercent and rentalDays
     */
    @Test
    public void checkoutTest5() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date checkoutDate = formatter.parse("07/02/15");
        Checkout checkout = new Checkout("JAKR", checkoutDate, 9, 0);
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        assertEquals("JAKR", rentalAgreement.getTool().getCode());
        assertEquals("Jackhammer", rentalAgreement.getTool().getType());
        assertEquals("Rigid", rentalAgreement.getTool().getBrand());
        assertEquals(9, rentalAgreement.getCheckout().getRentalDays());
        assertEquals(checkoutDate, rentalAgreement.getCheckout().getCheckoutDate());
        assertEquals("07/11/15",formatter.format(rentalAgreement.getDueDate()));
        assertEquals(2.99, rentalAgreement.getDailyRentalCharge(),0);
        assertEquals(5, rentalAgreement.getChargeableDays());
        assertEquals(14.95, rentalAgreement.getPreDiscountCharge(), 0);
        assertEquals(0, rentalAgreement.getCheckout().getDiscountPercent(),0);
        assertEquals(0.00, rentalAgreement.getDiscountAmount(), 0);
        assertEquals(14.95, rentalAgreement.getFinalCharge(), 0);
    }

    /**
     * Test case 6 per programming demo documentation
     *
     * @throws Exception IllegalArgumentException for validation discountPercent and rentalDays
     */
    @Test
    public void checkoutTest6() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date checkoutDate = formatter.parse("07/02/20");
        Checkout checkout = new Checkout("JAKR", checkoutDate, 4, 50);
        RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
        assertEquals("JAKR", rentalAgreement.getTool().getCode());
        assertEquals("Jackhammer", rentalAgreement.getTool().getType());
        assertEquals("Rigid", rentalAgreement.getTool().getBrand());
        assertEquals(4, rentalAgreement.getCheckout().getRentalDays());
        assertEquals(checkoutDate, rentalAgreement.getCheckout().getCheckoutDate());
        assertEquals("07/06/20",formatter.format(rentalAgreement.getDueDate()));
        assertEquals(2.99, rentalAgreement.getDailyRentalCharge(),0);
        assertEquals(1, rentalAgreement.getChargeableDays());
        assertEquals(2.99, rentalAgreement.getPreDiscountCharge(), 0);
        assertEquals(50, rentalAgreement.getCheckout().getDiscountPercent(),0);
        assertEquals(1.50, rentalAgreement.getDiscountAmount(), 0);
        assertEquals(1.49, rentalAgreement.getFinalCharge(), 0);
    }

}
