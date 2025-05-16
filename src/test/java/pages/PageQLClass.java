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

    public void ClickDenLop(){
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//p[text()='Lớp học']")).click();
        driver.findElement(By.xpath("//a[p[text()='0028']]")).click();

    }

    public void ClickDaoTao(){
        driver.findElement(By.xpath("//div[contains(@class,'MuiButtonGroup-root')]//button[@type='button']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiAutocomplete-endAdornment')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPopper-root MuiAutocomplete-popper css-1mtsuo7')]//ul//li[@id='asynchronous-option-0']")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiInputAdornment-root')]//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'labelContainer')]//button[@type='button'])")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPickersYear-root css-j9zntq')]//button[text()='2018']")).click();
        driver.findElement(By.xpath("//div[@aria-rowindex='3']//button[text()='15']")).click();
        driver.findElement(By.xpath("//input[@value='STUDENT_TRIAL']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiDialogActions-spacing')]//button[text()='Lưu']")).click();

    }

    public void ClickGhiDanhKhongChonHV(){
        driver.findElement(By.xpath("//div[contains(@class,'MuiButtonGroup-root')]//button[@type='button']")).click();
        driver.findElement(By.xpath("//button[text()='Lưu']")).click();

    }

    public void ClickTangGiamSoBuoi(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='IsoIcon'])[1]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiInputBase-colorPrimary MuiInputBase-fullWidth ')]//input[@id='name'])[1]")).sendKeys("-100");
        driver.findElement(By.xpath("//div[contains(@class, 'MuiDialogActions-spacing')]//button[text()='Lưu']")).click();

    }

    public void ClickTangGiamSoBuoiChu(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='IsoIcon'])[1]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiInputBase-colorPrimary MuiInputBase-fullWidth ')]//input[@id='name'])[1]")).sendKeys("<script> alert(\"Thông báo: Chào bạn đến với Jira!\");</script>");
        driver.findElement(By.xpath("//div[contains(@class, 'MuiDialogActions-spacing')]//button[text()='Lưu']")).click();

    }

    public void ChuyenLopSoBuoiAm(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='TransferWithinAStationIcon'])[1]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete-endAdornment')]//button[@title='Open'])[2]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPopper-root MuiAutocomplete-popper css-1mtsuo7')]//ul//li[@id='asynchronous-option-0']")).click();
        driver.findElement(By.xpath("//input[@type='number']")).clear();
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("-50");
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiInputAdornment-root')]//button[@type='button'])[3]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'labelContainer')]//button[@type='button'])")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPickersYear-root css-j9zntq')]//button[text()='2030']")).click();
        driver.findElement(By.xpath("//div[@aria-rowindex='3']//button[text()='15']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiDialogActions-spacing')]//button[text()='Lưu']")).click();
    }

    public void BaoLuu(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='HistoryIcon'])[1]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiInputAdornment')]//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'labelContainer')]//button[@type='button'])")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPickersYear-root css-j9zntq')]//button[text()='2018']")).click();
        driver.findElement(By.xpath("//div[@aria-rowindex='3']//button[text()='14']")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiInputBase-colorPrimary MuiInputBase-fullWidth')]//input[@id='name'])[2]")).sendKeys("-5");
        driver.findElement(By.xpath("//div[contains(@class, 'MuiDialogActions-spacing')]//button[text()='Lưu']")).click();

    }

    public void BaoNghi(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='HighlightOffIcon'])[1]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiInputAdornment')]//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'labelContainer')]//button[@type='button'])")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPickersYear-root css-j9zntq')]//button[text()='2018']")).click();
        driver.findElement(By.xpath("//div[@aria-rowindex='3']//button[text()='14']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiDialogActions-spacing')]//button[text()='Xác nhận']")).click();

    }
}


