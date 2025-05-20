package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageQLDiemDanh {
    WebDriver driver;
    public PageQLDiemDanh(WebDriver driver) {
        this.driver = driver;

    }
    //Actions actions = new Actions(driver);
    public void ClickDenLichSuDiemDanh(){
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
    }

    public void TimKiemHV(){
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation1')]//li[@id='asynchronous-option-1']")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[3]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation1')]//li[@id='asynchronous-option-0']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiInputBase-formControl')]//div[(@id = 'student-status')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation')]//li[text() = 'Có mặt']")).click();
    }

    public void TimKiemHV1trong3ttsai(){
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation1')]//li[@id='asynchronous-option-1']")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[3]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation1')]//li[@id='asynchronous-option-1']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiInputBase-formControl')]//div[(@id = 'student-status')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation')]//li[text() = 'Có mặt']")).click();
    }

    public void TimKiemTheoGV(){
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation1')]//li[@id='asynchronous-option-1']")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[3]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation1')]//li[@id='asynchronous-option-0']")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[2]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation')]//li[@id = 'asynchronous-option-0']")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Clear'])[2]")).click();

        driver.findElement(By.xpath("//div[contains(@class, 'MuiInputBase-formControl')]//div[(@id = 'student-status')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation')]//li[text() = 'Có mặt']")).click();
    }

}
