import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homepage extends Base {

    @Test(description = "Verify Home Page Title", priority = 1)
    public void verifyHomepageTitle(){
        String Title = driver.getTitle();
        Assert.assertEquals(Title , "Your Store");
        System.out.println("Homepage title verified.");
    }
    @Test(description = "Verify Add to Cart from Homepage", priority = 2)
    public void verifyAddToCartFromHomepage() {
        By firstProductAddToCart = By.xpath("//div[@class='product-thumb']//button[@type='submit'][1]");

        wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToCart));
        driver.findElement(firstProductAddToCart).click();

        By successAlert = By.xpath("//div[contains(@class, 'alert-success')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));

        String alertText = driver.findElement(successAlert).getText();
        Assert.assertTrue(alertText.contains("Success: You have added"), "Success message did not appear.");
        System.out.println("Product added to cart from homepage successfully.");
    }
    @Test(description = "Verify Search Functionality" , priority = 3)
    public void verifySearch(){
        driver.findElement(By.name("search")).sendKeys("Mac Book");
        WebElement searchButton =driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        wait.until(ExpectedConditions.titleIs("Search - Mac Book"));
        String Title = driver.getTitle();
        Assert.assertEquals( Title, "Search - Mac Book");
        System.out.println("Search functionality verified.");
    }

    @Test(description = "Verify Currency Change Functionality", priority = 4)
    public void verifyCurrencyChange() {
        By currencyLocator = By.xpath("//span[contains(@class ,'d-none')]");
        By euroLocator = By.xpath("//a[text()='€ Euro']");
        By dollarLocator = By.xpath("//a[text()='$ US Dollar']");
        By symboleLocator = By.xpath("//form[@id='form-currency']//strong");

        driver.findElement(currencyLocator).click();
        driver.findElement(dollarLocator).click();

        wait.until(ExpectedConditions.textToBe(symboleLocator , "$"));
        String newSymbol= driver.findElement(symboleLocator).getText();
        Assert.assertEquals(newSymbol, "$");

        System.out.println("Currency changed to dollar successfully.");

    }



}
