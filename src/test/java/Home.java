import org.testng.Assert;
import org.testng.annotations.Test;

public class Home extends Base {

    @Test(description = "Verify Home Page Title", priority = 1)
    public void verifyHomepageTitle(){
        String title = registrationPage.getPageTitle("Your Store");
        Assert.assertEquals(title, "Your Store");
        System.out.println("Homepage title verified.");
    }
    @Test(description = "Verify Add to Cart from Homepage", priority = 2)
    public void verifyAddToCartFromHomepage() {
        homePage.addFirstProductToCart();
        Assert.assertTrue(homePage.isSuccessMessageDisplayed(), "Success message did not appear.");
        String alertText = homePage.getSuccessMessageText();
        Assert.assertTrue(alertText.contains("Success: You have added"), "Message text is wrong!");
        System.out.println("Product added to cart from homepage successfully.");
    }
    @Test(description = "Verify Search Functionality" , priority = 3)
    public void verifySearch(){
        homePage.searchForProduct("Mac Book");
        String title = homePage.getPageTitle("Search - Mac Book");
        Assert.assertEquals(title, "Search - Mac Book");
        System.out.println("Search functionality verified.");
    }

    @Test(description = "Verify Currency Change Functionality", priority = 4)
    public void verifyCurrencyChange() {
        homePage.changeCurrencyToEuro();
        homePage.waitForCurrencySymbol("€");
        String newSymbol = homePage.getCurrentCurrencySymbol();
        Assert.assertEquals(newSymbol, "€");
        System.out.println("Currency changed to euro successfully.");
    }



}
