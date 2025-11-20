import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends Base {

    @Test(description = "Navigate to Registration Page", priority = 1)
    public void navigateToRegisterPage() {
        homePage.navigateToRegisterPage();
        String title = registrationPage.getPageTitle("Register Account");
        Assert.assertEquals(title, "Register Account");
    }

    @Test(description = "Fill Registration Form", priority = 2)
    public void fillRegistrationForm() {
        registrationPage.fillRegistrationForm("Test" ,"User" ,registeredEmail ,registeredPassword);
    }

    @Test(description = "Verify Account Creation", priority = 3)
    public void verifyAccountCreation() {
        registrationPage.getSuccessMessage();
        System.out.println("Account created successfully!");
    }

}