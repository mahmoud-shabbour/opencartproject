package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage{
    //=============Constructor===============
    public MyAccountPage(WebDriver driver , WebDriverWait wait){
        super(driver, wait);
    }

    //=============Locators=================
    By editAccountLink = By.xpath("//a[text()='Edit your account information']");
    By passwordLink = By.xpath("//a[text()='Change your password']");
    By addressBookLink = By.xpath("//a[text()='Modify your address book entries']");
    By newsletterLink = By.xpath("//a[text()='Subscribe / unsubscribe to newsletter']");
    By orderHistoryLink = By.xpath("//a[text()='View your order history']");
    By successMessage = By.xpath("//div[contains(@class, 'alert-success')]");

    By lastNameInput = By.id("input-lastname");
    By continueBtn = By.xpath("//button[@class='btn btn-primary']");

    By passwordInput = By.id("input-password");
    By confirmPasswordInput = By.id("input-confirm");

    //============Actions==================
    public void navigateToEditAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(editAccountLink));
        driver.findElement(editAccountLink).click();
    }

    public void navigateToChangePassword() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordLink));
        driver.findElement(passwordLink).click();
    }

    public void navigateToAddressBook() {
        wait.until(ExpectedConditions.elementToBeClickable(addressBookLink));
        driver.findElement(addressBookLink).click();
    }

    public void navigateToNewsletter() {
        wait.until(ExpectedConditions.elementToBeClickable(newsletterLink));
        driver.findElement(newsletterLink).click();
    }

    public void navigateToOrderHistory() {
        wait.until(ExpectedConditions.elementToBeClickable(orderHistoryLink));
        driver.findElement(orderHistoryLink).click();
    }

    public void editLastName(String newName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(newName);
        driver.findElement(continueBtn).click();
    }

    public void changePassword(String newPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(newPassword);
        driver.findElement(confirmPasswordInput).sendKeys(newPassword);
        driver.findElement(continueBtn).click();
    }
    public boolean isSuccessMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }



}
