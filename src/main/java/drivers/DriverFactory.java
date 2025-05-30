package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

//    static WebDriver driver;

    public static void setDriver(String browser){

        WebDriver driver = null;

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                //driver = new ChromeDriver();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");  // chạy ở chế độ ẩn danh
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("This browser is not support");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        threadLocalDriver.set(driver);
    }

    public static WebDriver getDriver() {

        return threadLocalDriver.get();
//        return driver;
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
