import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginInvalidCradential extends Base{

    public static void verifyErrorMessage(){
        WebElement errorMessage= driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not visible.");

    }

    @Test(description = "Navigate to Login Page" , priority = 1)
    public void navigateToLoginPage(){
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();

        By loginlocator =By.xpath("//a[@class='dropdown-item' and text()='Login']");
        wait.until(ExpectedConditions.elementToBeClickable(loginlocator)); //in wait.until (webelement or locator)
        driver.findElement(loginlocator).click();
        WebElement returningCustomer = driver.findElement(By.xpath("//h2[text()='Returning Customer']"));
        Assert.assertTrue(returningCustomer.isDisplayed(), "'Returning Customer' text is not visible");

    }
    @Test(description = "Enter incorrect email and correct password and click login", priority = 2)
    public void enterIncorrectCredentials0() {
        driver.findElement(By.id("input-email")).sendKeys("wrong@test.com");
        driver.findElement(By.id("input-password")).sendKeys(registeredPassword);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        verifyErrorMessage();
    }
    @Test(description = "Enter incorrect email and incorrect password and click login", priority = 3)
    public void enterIncorrectCredentials1() {
        driver.findElement(By.id("input-email")).sendKeys("wrong@test.com");
        driver.findElement(By.id("input-password")).sendKeys("wrong pass");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        verifyErrorMessage();

    }
    @Test(description = "Enter correct email and incorrect password and click login", priority = 4)
    public void enterIncorrectCredentials2() {
        driver.findElement(By.id("input-email")).sendKeys(registeredEmail);
        driver.findElement(By.id("input-password")).sendKeys("wrong pass");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        verifyErrorMessage();

    }
}
