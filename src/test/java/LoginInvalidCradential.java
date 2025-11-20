import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginInvalidCradential extends Base{

    @Test(description = "Navigate to Login Page" , priority = 1)
    public void navigateToLoginPage(){
        homePage.navigateToLoginPage();
        String title = loginPage.getPageTitle("Account Login");
        Assert.assertEquals(title, "Account Login", "Page title is not correct");
        Assert.assertTrue(loginPage.isReturningCustomerDisplayed(), "'Returning Customer' text is not visible");
    }

    @Test(description = "Enter incorrect email and correct password and click login", priority = 2)
    public void enterIncorrectCredentials0() {
        loginPage.enterEmail("wrong@test.com");
        loginPage.enterPassword(registeredPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not visible.");
    }

    @Test(description = "Enter incorrect email and incorrect password and click login", priority = 3)
    public void enterIncorrectCredentials1() {
        loginPage.enterEmail("wrong@test.com");
        loginPage.enterPassword("wrong pass");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not visible.");
    }

    @Test(description = "Enter correct email and incorrect password and click login", priority = 4)
    public void enterIncorrectCredentials2() {
        loginPage.enterEmail(registeredEmail);
        loginPage.enterPassword("wrong pass");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not visible.");
    }

}
