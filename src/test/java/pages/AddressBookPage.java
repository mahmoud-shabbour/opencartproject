package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPage extends BasePage{
    //=======Constructor========
    public AddressBookPage(WebDriver driver , WebDriverWait wait){
        super(driver , wait);
    }

    //=======Locators===========
    By newAddressBtn = By.xpath("//a[text()='New Address']");
    By firstNameInput = By.id("input-firstname");
    By lastNameInput = By.id("input-lastname");
    By address1Input = By.id("input-address-1");
    By cityInput = By.id("input-city");
    By postCodeInput = By.id("input-postcode");
    By countryDropdown = By.id("input-country");
    By zoneDropdown = By.id("input-zone");
    By continueBtn = By.xpath("//button[contains(@class , 'btn-primary')]");

    //===========Actions============
    public void clickNewAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(newAddressBtn));
        driver.findElement(newAddressBtn).click();
    }

    public void fillAddressForm(String fName, String lName, String address, String city, String code, String country, String region) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        driver.findElement(firstNameInput).sendKeys(fName);
        driver.findElement(lastNameInput).sendKeys(lName);
        driver.findElement(address1Input).sendKeys(address);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(postCodeInput).sendKeys(code);

        Select selectCountry = new Select(driver.findElement(countryDropdown));
        selectCountry.selectByVisibleText(country);

        wait.until(ExpectedConditions.textToBePresentInElementLocated(zoneDropdown ,region));
        Select selectZone = new Select(driver.findElement(zoneDropdown));
        selectZone.selectByVisibleText(region);

        driver.findElement(continueBtn).click();
    }
}
