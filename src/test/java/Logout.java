import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout extends Base {

    @Test(description = "Click Logout button", priority = 7)
    public void clickLogoutButton() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        System.out.println("Logout button clicked.");
    }

    @Test(description = "Verify successful logout", priority = 8)
    public void verifySuccessfulLogout() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Account Logout", "Logout failed.");
        System.out.println("Logout successful!");
    }
}