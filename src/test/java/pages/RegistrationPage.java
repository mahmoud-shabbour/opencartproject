package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
    //=============Constructor=============
    public RegistrationPage(WebDriver driver , WebDriverWait wait){
        super(driver , wait);
    }

    //==============Locators===============
    By firstNameField=By.id("input-firstname");
    By lastNameField=By.id("input-lastname");
    By emailField =By.id("input-email");
    By passwordField =By.id("input-password");
    By privacyCheckbox = By.name("agree");
    By continueButton = By.xpath("//button[text()='Continue']");
    By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");

    By myAccountDropdown = By.xpath("//span[text()='My Account']");
    By logoutLink =By.linkText("Logout");

    //=============Action===================
    public void fillRegistrationForm(String fName, String lName, String email, String password) {
        driver.findElement(firstNameField).sendKeys(fName);
        driver.findElement(lastNameField).sendKeys(lName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(privacyCheckbox).click();
        driver.findElement(continueButton).click();
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(successMessage));
        return driver.findElement(successMessage).getText();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropdown));
        driver.findElement(myAccountDropdown).click();

        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        driver.findElement(logoutLink).click();
    }


}
