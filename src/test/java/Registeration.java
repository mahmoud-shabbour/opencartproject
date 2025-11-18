import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Registeration extends Base {


    @Test(description = "Navigate to Registration Page", priority = 1)
    public void navigateToRegisterPage() {
        // click on "My Account"
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        // click on "Register"
        driver.findElement(By.linkText("Register")).click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Register Account");
    }

    @Test(description = "Fill Registration Form", priority = 2)
    public void fillRegistrationForm() {
        // Fill Registration data
        driver.findElement(By.id("input-firstname")).sendKeys("Test");
        driver.findElement(By.id("input-lastname")).sendKeys("User");

        driver.findElement(By.id("input-email")).sendKeys(registeredEmail);

        driver.findElement(By.id("input-password")).sendKeys(registeredPassword);

        driver.findElement(By.name("agree")).click();

        driver.findElement(By.xpath("//button[text()='Continue']")).click();
    }

    @Test(description = "Verify Account Creation", priority = 3)
    public void verifyAccountCreation() {

        By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");
        wait.until(ExpectedConditions.textToBe(successMessage, "Your Account Has Been Created!"));

        System.out.println("Account created successfully!");
    }



}