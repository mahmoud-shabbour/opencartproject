package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    //================Constructor=====================
    public HomePage(WebDriver driver , WebDriverWait wait){
        super(driver , wait);

    }

    //================Locator=========================
    By myAccountDropdown=By.xpath("//span[text()='My Account']");
    By registerLink=By.partialLinkText("Register");
    By loginLink= By.xpath("//a[text()='Login' and contains(@href ,'route=account/login') and contains(@class ,'dropdown-item')]");

    By myAccountLink= By.xpath("//a[text()='My Account']");

    // Search Functionality
    By searchBox = By.name("search");
    By searchButton = By.xpath("//button[@type='submit']");

    // Add to Cart
    By firstProductAddToCart = By.xpath("(//div[@class='product-thumb']//button)[1]");
    By successAlert = By.xpath("//div[contains(@class, 'alert-success')]");

    // Currency Change
    By currencyDropdown = By.xpath("//span[contains(@class ,'d-none')]");
    By euroOption = By.xpath("//a[text()='€ Euro']");
    By dollarOption = By.xpath("//a[text()='$ US Dollar']");
    By currencySymbolStrong = By.xpath("//form[@id='form-currency']//strong");

    By checkoutLink = By.xpath("//span[text()='Checkout']");

    //-----
    By shoppingCartLink = By.xpath("//span[text()='Shopping Cart']");
    By wishlistLink = By.xpath("//span[contains(text() ,'Wish List')]");
    By firstProductWishlist = By.xpath("(//div[@class='product-thumb']//button)[2]");


    //=================Actions========================
    public void navigateToRegisterPage() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropdown));
        driver.findElement(myAccountDropdown).click();

        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();
    }

    public void navigateToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropdown));
        driver.findElement(myAccountDropdown).click();

        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
    }

    public void searchForProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToCart));
        driver.findElement(firstProductAddToCart).click();
    }

    public boolean isSuccessMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
        return driver.findElement(successAlert).isDisplayed();
    }

    public String getSuccessMessageText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
        return driver.findElement(successAlert).getText();
    }

    public void changeCurrencyToDollar() {
        driver.findElement(currencyDropdown).click();
        driver.findElement(dollarOption).click();
    }

    public void changeCurrencyToEuro() {
        driver.findElement(currencyDropdown).click();
        driver.findElement(euroOption).click();
    }

    public String getCurrentCurrencySymbol() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(currencySymbolStrong));
        return driver.findElement(currencySymbolStrong).getText();
    }

    public void waitForCurrencySymbol(String symbol) {
        wait.until(ExpectedConditions.textToBe(currencySymbolStrong, symbol));
    }

    public void navigateToCheckoutPage() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutLink));
        driver.findElement(checkoutLink).click();

    }

    public void navigateToMyAccountPage() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropdown));
        driver.findElement(myAccountDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLink));
        driver.findElement(myAccountLink).click();
    }
    public void navigateToShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
        driver.findElement(shoppingCartLink).click();
    }
    public void navigateToWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(wishlistLink));
        driver.findElement(wishlistLink).click();
    }
    public void addFirstProductToWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductWishlist));
        driver.findElement(firstProductWishlist).click();
    }
    public void navigateToHomePage() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("http://localhost/opencartproject/");
    }

}
