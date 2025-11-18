import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginValidCradential extends Base{
    @Test(description = "Navigate to Login Page", priority = 4)
    public void navigateToLoginPage() {
//        //click my account then logout
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        driver.findElement(By.linkText("Logout")).click();

        By myAccountLocator = By.xpath("//span[text()='My Account']");
        By loginLocator = By.xpath("//a[text()='Login' and contains(@href ,'route=account/login') and contains(@class ,'dropdown-item')]");

        wait.until(ExpectedConditions.elementToBeClickable(myAccountLocator));
        driver.findElement(myAccountLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLocator));
        driver.findElement(loginLocator).click();

        wait.until(ExpectedConditions.titleIs("Account Login"));
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Account Login");


        WebElement returningCustomer = driver.findElement(By.xpath("//h2[text()='Returning Customer']"));
        Assert.assertTrue(returningCustomer.isDisplayed(), "'Returning Customer' text is not visible");
    }


    @Test(description = "Enter correct email and password and click login", priority = 5)
    public void enterCorrectCredentials() {
        driver.findElement(By.id("input-email")).sendKeys(registeredEmail);
        driver.findElement(By.id("input-password")).sendKeys(registeredPassword);
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        System.out.println("Attempting correct login with: " + registeredEmail);
    }

    @Test(description = "Verify successful login", priority = 6)
    public void verifySuccessfulLogin() {
        wait.until(ExpectedConditions.titleIs("My Account"));

        String title = driver.getTitle();
        Assert.assertEquals(title, "My Account", "Login failed.");

        WebElement myAccountHeading = driver.findElement(By.xpath("//h1[text()='My Account']"));
        wait.until(ExpectedConditions.visibilityOf(myAccountHeading)); //WebElement
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='My Account']"))); //locator

        Assert.assertTrue(myAccountHeading.isDisplayed(), "My Account heading is not visible after login.");

        System.out.println("Login successful!");
    }
}
