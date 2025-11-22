package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{
    //===========Constructor=============
    public CartPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    //============Locators==============
    By quantityInput = By.xpath("//input[@name='quantity']");
    By updateBtn = By.xpath("//button[@type='submit' and contains(@class, 'btn-primary')]");
    By removeBtn = By.xpath("//a[contains(@class, 'btn-danger')]");
    By checkoutBtn = By.xpath("//a[contains(@href, 'checkout/checkout') and contains(@class, 'btn-primary')]");

    By couponAccordion = By.xpath("//button[text()='Use Coupon Code']");
    By couponInput = By.id("input-coupon");
    By applyCouponBtn = By.xpath("//button[text()='Apply Coupon']");

    By successMessage = By.cssSelector("div.alert-success");
    By errorMessage = By.cssSelector("div.alert-danger");
    By emptyCartText = By.xpath("//p[contains(text(), 'empty')]");

    //===============Actions=====================
    public void updateQuantity(String quantity) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput));
        driver.findElement(quantityInput).clear();
        driver.findElement(quantityInput).sendKeys(quantity);
        driver.findElement(updateBtn).click();
    }

    public void applyCoupon(String code) {
        wait.until(ExpectedConditions.elementToBeClickable(couponAccordion));
        driver.findElement(couponAccordion).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponInput));
        driver.findElement(couponInput).sendKeys(code);
        driver.findElement(applyCouponBtn).click();
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        driver.findElement(checkoutBtn).click();
    }

    public void removeItem() {
        wait.until(ExpectedConditions.elementToBeClickable(removeBtn));
        driver.findElement(removeBtn).click();
    }

    public boolean isSuccessMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isEmptyTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartText));
        return driver.findElement(emptyCartText).isDisplayed();
    }

}
