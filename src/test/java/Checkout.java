import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout extends Base{

    String email = "guest" + System.currentTimeMillis() + "@test.com";

    @Test(priority = 1, description = "Navigate to Checkout Page")
    public void navigateToCheckout() {
        homePage.addFirstProductToCart();
        homePage.navigateToCheckoutPage();
        Assert.assertTrue(driver.getTitle().contains("Checkout"));
    }

    @Test(priority = 2, description = "Select Guest Checkout Mode")
    public void selectGuestMode() {
        checkoutPage.selectGuestCheckout();
    }

    @Test(priority = 3, description = "Fill Personal Information")
    public void fillPersonalDetails() {
        checkoutPage.fillPersonalData("Mahmoud", "Tester", email);
    }

    @Test(priority = 4, description = "Fill Shipping Address")
    public void fillAddressDetails() {
        checkoutPage.fillAddressData("123 Tahrir St", "Cairo", "Cairo", "1151", "Egypt" , "Al Qahirah");
        Assert.assertTrue(checkoutPage.isStepSuccessDisplayed(), "Error: Success message did NOT appear after saving details!");
    }

    @Test(priority = 5, description = "Shipping > Verify 'Changed Shipping' Message")
    public void shippingStep() {
        checkoutPage.handleShippingMethod();
        Assert.assertTrue(checkoutPage.isStepSuccessDisplayed(), "Error: Success message did NOT appear after shipping!");
    }

    @Test(priority = 6, description = "Payment > Verify 'Changed Payment' Message")
    public void paymentStep() {
        checkoutPage.handlePaymentMethod();
        Assert.assertTrue(checkoutPage.isStepSuccessDisplayed(), "Error: Success message did NOT appear after payment!");

    }

    @Test(priority = 7, description = "Confirm Order & Verify Final Page")
    public void confirmOrder() {
        checkoutPage.clickConfirmOrder();
        Assert.assertTrue(checkoutPage.isOrderPlacedPageDisplayed(), "Success Page NOT displayed!");
        String title = checkoutPage.getPageTitle("Your order has been placed!");
        Assert.assertEquals(title, "Your order has been placed!");
        System.out.println("Order Placed Successfully & Final Page Verified!");
    }

    @Test(priority = 8, description = "Finish Journey")
    public void finish() {
        checkoutPage.clickContinueAfterSuccess();
        Assert.assertEquals(driver.getTitle(), "Your Store");
    }

}
