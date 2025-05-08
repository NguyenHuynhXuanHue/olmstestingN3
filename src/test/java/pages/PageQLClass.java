package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageQLClass {

    WebDriver driver;
    public PageQLClass(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickDaoTao(){

        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//p[text()='Lớp học']")).click();
        driver.findElement(By.xpath("//a[p[text()='0028']]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'MuiButtonGroup-root')]//button[@type='button']")).click();
        WebElement inputBox = driver.findElement(By.id("asynchronous"));
        inputBox.clear();
        inputBox.sendKeys("Hoàng Anh Khang");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@value='Hoàng Anh Khang - Lucas (10/10/2019) (Chị Vân - 0989527759)']")
        ));

        // 3. Click vào gợi ý
        suggestion.click();



    }

    public void ClickGhiDanhKhongChonHV(){

        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//p[text()='Lớp học']")).click();
        driver.findElement(By.xpath("//a[p[text()='0028']]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'MuiButtonGroup-root')]//button[@type='button']")).click();
        driver.findElement(By.xpath("//button[text()='Lưu']")).click();



    }
}


