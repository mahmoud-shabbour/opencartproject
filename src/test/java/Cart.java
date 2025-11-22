import org.testng.Assert;
import org.testng.annotations.Test;

public class Cart extends Base{

    @Test(priority = 1, description = "Verify updating product quantity in cart")
    public void updateCartQuantity() {
        homePage.addFirstProductToCart();
        homePage.navigateToShoppingCart();
        cartPage.updateQuantity("2");
        Assert.assertTrue(cartPage.isSuccessMessageDisplayed());
    }

    @Test(priority = 2, description = "Verify error message for invalid coupon code")
    public void applyInvalidCoupon() throws InterruptedException {
        Thread.sleep(1000);
        cartPage.applyCoupon("hjkj563000");
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.isErrorMessageDisplayed());
    }

    @Test(priority = 3, description = "Verify navigation to checkout page from cart")
    public void navigateToCheckoutFromCart() {
        cartPage.clickCheckoutButton();
        Assert.assertTrue(driver.getTitle().contains("Checkout"));
        driver.navigate().back();
    }

    @Test(priority = 4, description = "Verify removing item from cart")
    public void removeItemFromCart() {
        cartPage.removeItem();
        Assert.assertTrue(cartPage.isEmptyTextDisplayed());
    }
}
