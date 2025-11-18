import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class Base {
    public static WebDriver driver;
    public static String registeredEmail = "1234@test.com";
    public static String registeredPassword = "1236456";
    public static WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost/opencartproject/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Execution Started: Opening Local OpenCart");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("Execution Ended: Browser Closed");

    }

}
