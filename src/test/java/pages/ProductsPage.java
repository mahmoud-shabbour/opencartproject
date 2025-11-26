package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //============ Locators ===============
    By MacBook = By.id("MacBook");
    By iPhone = By.id("iPhone");
    By AppleCinema30 = By.id("AppleCinema30");
    By CanonEOS5D = By.id("CanonEOS5D");

    By RadioButtonMedium = By.name("option[218]");
    By TestTextBox = By.id("input-option-208");
    By SelectInput = By.xpath("//*[@id=\"input-option-217\"]");
    By Textarea = By.name("option[209]");
    By UploadFile = By.id("input-option-222");
    By Date = By.name("option[219]");
    By Time = By.id("input-option-221");
    By Time_Date = By.id("input-option-220");

    By MacBookImage = By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div/a/img");
    By MacBooktPrice = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2/span");

    By iphoneImage = By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div/a/img");
    By iphonePrice = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2/span");

    By AppleCinemaImage = By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div/a/img");
    By AppleCinemaPrice = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2/span");

    By CanonEOS5DImage = By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div/a/img");
    By CanonEOS5DPrice = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2/span");

    By addToWishlistBtn = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/form/div/button[1]");
    By addToCartVisibleBtn = By.xpath("//button[@id='button-cart']");

    By SelectOption = By.id("input-option-226");

    //============ Actions ================
    public void clickMacBook() {
        driver.findElement(MacBook).click();
    }

    public boolean isMacBookImageVisible() {
        return driver.findElement(MacBookImage).isDisplayed();
    }

    public boolean isMacBooktPriceVisible() {
        return driver.findElement(MacBooktPrice).isDisplayed();
    }

    public void clickIPhone() {
        driver.findElement(iPhone).click();
    }

    public boolean isiphoneImageVisible(){
        return driver.findElement(iphoneImage).isDisplayed();
    }

    public boolean isiphonePriseVisible(){
        return driver.findElement(iphonePrice).isDisplayed();
    }

    public void clickAppleCinema() {
        driver.findElement(AppleCinema30).click();
    }

    public boolean isAppleCinema30ImageVisible() {
        return driver.findElement(AppleCinemaImage).isDisplayed();
    }

    public boolean isAppleCinema30PriceVisible() {
        return driver.findElement(AppleCinemaPrice).isDisplayed();
    }

    public void ClickCanonEOS5D() {
        driver.findElement(CanonEOS5D).click();
    }

    public boolean isCanonEOS5DImageVisible() {
        return driver.findElement(CanonEOS5DImage).isDisplayed();
    }

    public boolean isCanonEOS5DPriceVisible() {
        return driver.findElement(CanonEOS5DPrice).isDisplayed();
    }

    public boolean isSelectOptionisVisible() {
        return driver.findElement(SelectOption).isDisplayed();
    }

    public boolean isAddToWishlistVisible() {
        return driver.findElement(addToWishlistBtn).isDisplayed();
    }

    public boolean isAddToCartVisible() {
        return driver.findElement(addToCartVisibleBtn).isDisplayed();
    }

    //============ SendKeys Actions ================
    public void fillProductOptions() {
        // Radio button Medium
        driver.findElement(RadioButtonMedium).click();

        // Test TextBox
        driver.findElement(TestTextBox).sendKeys("Test");

        // Select Input Red
        driver.findElement(SelectInput).sendKeys("Red (+$6.80)");

        // Textarea
        driver.findElement(Textarea).sendKeys("TEXT");

        // Date
        driver.findElement(Date).sendKeys("26/11/2025");

        // Time
        driver.findElement(Time).sendKeys("5:00");

        // DateTime
        driver.findElement(Time_Date).sendKeys("5/1/2026 10:00");
    }

    //============ Upload File Action ================
    public void uploadFile(String filePath) {
        driver.findElement(UploadFile).sendKeys("");
    }
}
