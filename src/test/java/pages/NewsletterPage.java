package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsletterPage extends BasePage{
    //===========Constructor=============
    public NewsletterPage(WebDriver driver , WebDriverWait wait){
        super(driver , wait);
    }

    //============Locators================
    By subscribeBtn=By.xpath("//input[@id='input-newsletter']");
    By continueBtn = By.xpath("//button[contains(@class , 'btn-primary')]");

    //=============Actions================
    public void subscribe() {
        wait.until(ExpectedConditions.elementToBeClickable(subscribeBtn));
        driver.findElement(subscribeBtn).click();
        driver.findElement(continueBtn).click();
    }

    public void unsubscribe() {
        wait.until(ExpectedConditions.elementToBeClickable(subscribeBtn));
        driver.findElement(subscribeBtn).click();
        driver.findElement(continueBtn).click();
    }
}
