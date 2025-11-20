import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;
import java.time.Duration;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    // Will Change Manually
    public static String registeredEmail = "6046857@test.com";
    public static String registeredPassword = "1234956";
    // Pages Object Declaration
    public static HomePage homePage;
    public static RegistrationPage registrationPage;
    public static LoginPage loginPage;
    public static CheckoutPage checkoutPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Pages Object Initialization
        homePage = new HomePage(driver , wait);
        registrationPage = new RegistrationPage(driver , wait);
        loginPage = new LoginPage(driver , wait);
        checkoutPage = new CheckoutPage(driver, wait);

        driver.get("http://localhost/opencartproject/");
        wait.until(ExpectedConditions.urlContains("opencartproject"));
        System.out.println("Execution Started: Opening Local OpenCart");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("Execution Ended: Browser Closed");

    }

}
