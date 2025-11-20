import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout extends Base {

    @Test(description = "Click Logout button", priority = 7)
    public void clickLogoutButton() {
        registrationPage.logout();
        System.out.println("Logout button clicked.");
    }

    @Test(description = "Verify successful logout", priority = 8)
    public void verifySuccessfulLogout() {
        String title = loginPage.getPageTitle("Account Logout");
        Assert.assertEquals(title, "Account Logout", "Logout failed.");
        System.out.println("Logout successful!");
    }
}