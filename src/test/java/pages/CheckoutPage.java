package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {
    //===========Constructor=============
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //============Locators===============
    By guestRadioBtn = By.id("input-guest");

    By firstNameInput = By.id("input-firstname");
    By lastNameInput = By.id("input-lastname");
    By emailInput = By.id("input-email");

    By addressInput = By.id("input-shipping-address-1");
    By address2Input = By.name("shipping_address_2");
    By cityInput = By.id("input-shipping-city");
    By postCodeInput = By.id("input-shipping-postcode");
    By countryDropdown = By.id("input-shipping-country");
    By zoneDropdown = By.id("input-shipping-zone");
    By btnContinue = By.xpath("//button[text() ='Continue']");

    // Shipping
    By btnShippingMethod = By.id("button-shipping-methods");
    By btnContinueShipping = By.id("button-shipping-method");

    // Payment
    By btnPaymentMethod = By.id("button-payment-methods");
    By btnContinuePayment = By.id("button-payment-method");

    // Confirm
    By confirmOrderBtn = By.id("button-confirm");

    By successAlert = By.cssSelector("div.alert-success");
    By continueBtnSuccessPage = By.xpath("//a[text()='Continue']");

    //====================Actions====================
    public void selectGuestCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(guestRadioBtn));
        driver.findElement(guestRadioBtn).click();
    }

    public void fillPersonalData(String fName, String lName, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        driver.findElement(firstNameInput).sendKeys(fName);
        driver.findElement(lastNameInput).sendKeys(lName);
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillAddressData(String address, String address2 , String city, String postCode, String country, String region) {
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(address2Input).sendKeys(address2);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(postCodeInput).sendKeys(postCode);

        Select selectCountry = new Select(driver.findElement(countryDropdown));
        selectCountry.selectByVisibleText(country);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(zoneDropdown, region));
        Select selectZone = new Select(driver.findElement(zoneDropdown));
        selectZone.selectByVisibleText(region);

        driver.findElement(btnContinue).click();
    }


    public void handleShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(btnShippingMethod));
        driver.findElement(btnShippingMethod).click();
        driver.findElement(btnContinueShipping).click();
    }

    public void handlePaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(btnPaymentMethod));
        driver.findElement(btnPaymentMethod).click();
        driver.findElement(btnContinuePayment).click();
    }

    public void clickConfirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));
        driver.findElement(confirmOrderBtn).click();
    }

    public boolean isStepSuccessDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
        return driver.findElement(successAlert).isDisplayed();
    }


    public boolean isOrderPlacedPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
        return driver.findElement(successAlert).isDisplayed();
    }

    public void clickContinueAfterSuccess() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtnSuccessPage));
        driver.findElement(continueBtnSuccessPage).click();
    }


}
