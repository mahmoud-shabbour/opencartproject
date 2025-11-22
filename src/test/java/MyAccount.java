import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccount extends Base{
    @Test(priority = 1, description = "Verify successful login with valid credentials")
    public void login() {
        homePage.navigateToLoginPage();
        loginPage.enterEmail(registeredEmail);
        loginPage.enterPassword(registeredPassword);
        loginPage.clickLoginButton();
    }

    @Test(priority = 2, description = "Verify editing account information (Last Name)")
    public void editAccountInformation() {
        myAccountPage.navigateToEditAccount();
        myAccountPage.editLastName("Updated");
        Assert.assertTrue(myAccountPage.isSuccessMessageDisplayed());
    }

    @Test(priority = 3, description = "Verify changing the account password")
    public void changePassword() {
        homePage.navigateToMyAccountPage();
        myAccountPage.navigateToChangePassword();
        myAccountPage.changePassword("333334");
        Assert.assertTrue(myAccountPage.isSuccessMessageDisplayed());
    }

    @Test(priority = 4, description = "Verify adding a new address to the address book")
    public void addNewAddress() {
        homePage.navigateToMyAccountPage();
        myAccountPage.navigateToAddressBook();

        addressBookPage.clickNewAddress();
        addressBookPage.fillAddressForm("Ali", "Tester", "New St", "Giza", "16611", "Egypt", "Qina");

        Assert.assertTrue(myAccountPage.isSuccessMessageDisplayed());
    }

    @Test(priority = 5, description = "Verify subscribing to the newsletter")
    public void subscribeNewsletter() {
        homePage.navigateToMyAccountPage();
        myAccountPage.navigateToNewsletter();

        newsletterPage.subscribe();
        Assert.assertTrue(myAccountPage.isSuccessMessageDisplayed());
    }

    @Test(priority = 6, description = "Verify navigating to Order History page")
    public void viewOrderHistory() {
        homePage.navigateToMyAccountPage();
        myAccountPage.navigateToOrderHistory();
        String title = myAccountPage.getPageTitle("Orders");
        Assert.assertEquals(title, "Orders");
    }


}
