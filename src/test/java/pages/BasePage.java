package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver , WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }

    public String getPageTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        return driver.getTitle();
    }

}
