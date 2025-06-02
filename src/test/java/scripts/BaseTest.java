package scripts;

import drivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    protected WebDriverWait wait;

    static Logger logger = LogManager.getLogger(BaseTest.class); // Use class reference

    private static final String DEFAULT_BROWSER = "chrome";

    @BeforeMethod
    @Parameters({"browser"})
    public void setupTest(@Optional(DEFAULT_BROWSER) String browser) {
        logger.info("Setting up WebDriver...");

        DriverFactory.setDriver(browser);
        driver = DriverFactory.getDriver();
        driver.get("https://olms.codedao.io.vn/login");

        logger.info("Navigated to test site: https://olms.codedao.io.vn/login");
    }


    /*@BeforeMethod
    public void setUp() {
        DriverFactory.setDriver("edge");
        driver = DriverFactory.getDriver();

        driver.manage().window().maximize();
        driver.get("https://olms.codedao.io.vn/login");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("OLMS"));
    }*/


//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            logger.info("Closing browser and quitting WebDriver...");
//            driver.quit();
//        }
//    }
}
