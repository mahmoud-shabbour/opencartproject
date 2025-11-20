import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginValidCradential extends Base{

    @Test(description = "Navigate to Login Page", priority = 4)
    public void navigateToLoginPage() {
       //click my account then logout
        registrationPage.logout();

        homePage.navigateToLoginPage();
        String title = loginPage.getPageTitle("Account Login");
        Assert.assertEquals(title, "Account Login");

        Assert.assertTrue(loginPage.isReturningCustomerDisplayed(), "'Returning Customer' text is not visible");
    }


    @Test(description = "Enter correct email and password and click login", priority = 5)
    public void enterCorrectCredentials() {
        loginPage.enterEmail(registeredEmail);
        loginPage.enterPassword(registeredPassword);
        loginPage.clickLoginButton();
        System.out.println("Attempting correct login with: " + registeredEmail);
    }

    @Test(description = "Verify successful login", priority = 6)
    public void verifySuccessfulLogin() {
        String title = loginPage.getPageTitle("My Account");
        Assert.assertEquals(title, "My Account");
        Assert.assertTrue(loginPage.isMyAccountHeadingDisplayed(), "My Account heading is not visible after login.");
        System.out.println("Login successful!");
    }
}
