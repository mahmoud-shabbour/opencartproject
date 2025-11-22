import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wishlist extends Base{

    @Test(priority = 5, description = "Verify adding a product to the Wishlist")
    public void addToWishlist() throws InterruptedException {
        homePage.navigateToLoginPage();
        loginPage.enterEmail(registeredEmail);
        loginPage.enterPassword("333334");
        loginPage.clickLoginButton();
        homePage.navigateToHomePage();
        String title = registrationPage.getPageTitle("Your Store");
        Assert.assertEquals(title, "Your Store");

        homePage.addFirstProductToWishlist();
        Assert.assertTrue(homePage.isSuccessMessageDisplayed());
    }

    @Test(priority = 6, description = "Verify adding a duplicate product to the Wishlist")
    public void addDuplicateItemToWishlist() {
        homePage.addFirstProductToWishlist();
        Assert.assertTrue(homePage.isSuccessMessageDisplayed());
    }

    @Test(priority = 7, description = "Verify navigating to product details page from Wishlist")
    public void navigateToProductFromWishlist() {
        homePage.navigateToWishlist();
        wishlistPage.clickProductImgLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("product"));
        driver.navigate().back();
    }

    @Test(priority = 8, description = "Verify moving a product from Wishlist to Shopping Cart")
    public void moveFromWishlistToCart() {
        wishlistPage.addProductToCartFromWishlist();
        Assert.assertTrue(wishlistPage.isSuccessMessageDisplayed());
    }

    @Test(priority = 9, description = "Verify removing a product from the Wishlist")
    public void removeFromWishlist() {
        homePage.navigateToWishlist();
        wishlistPage.removeProduct();
        Assert.assertTrue(wishlistPage.isSuccessMessageDisplayed());
        Assert.assertTrue(wishlistPage.isEmptyTextDisplayed());
    }
}
