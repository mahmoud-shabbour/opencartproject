package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    // Constructor
    public LoginPage(WebDriver driver , WebDriverWait wait){
        super(driver , wait);
    }

    // Locators
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//button[text()='Login']");
    By errorMessage = By.xpath("//div[contains(@class, 'alert-danger')]");
    By myAccountHeading = By.xpath("//h1[text()='My Account']");
    By returningCustomerHeading = By.xpath("//h2[text()='Returning Customer']");


    // Actions

    public void enterEmail(String emailText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(emailText);
    }

    public void enterPassword(String passwordText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(passwordText);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isMyAccountHeadingDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountHeading));
        return driver.findElement(myAccountHeading).isDisplayed();
    }

    public boolean isReturningCustomerDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(returningCustomerHeading));
        return driver.findElement(returningCustomerHeading).isDisplayed();
    }

}
