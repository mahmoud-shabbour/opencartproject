package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends BasePage{
    //===========Constructor=============
    public WishlistPage(WebDriver driver , WebDriverWait wait){
        super(driver, wait);
    }

    //===========Locators=================
    By productImgLink = By.xpath("//td[@class='text-center']//a");
    By addToCartIcon = By.xpath("//button[@class='btn btn-primary mb-1']");
    By removeBtn = By.xpath("//a[contains(@href, 'remove')]");

    By successMessage = By.cssSelector("div.alert-success");
    By emptyWishlistText = By.xpath("//p[text()='Your wish list is empty.']");

    //===========Actions================
    public void clickProductImgLink() {
        wait.until(ExpectedConditions.elementToBeClickable(productImgLink));
        driver.findElement(productImgLink).click();
    }

    public void addProductToCartFromWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartIcon));
        driver.findElement(addToCartIcon).click();
    }

    public void removeProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(removeBtn));
        driver.findElement(removeBtn).click();
    }

    public boolean isSuccessMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isEmptyTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyWishlistText));
        return driver.findElement(emptyWishlistText).isDisplayed();
    }
}
