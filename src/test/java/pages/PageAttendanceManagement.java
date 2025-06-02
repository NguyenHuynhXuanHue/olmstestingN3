package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageAttendanceManagement {
    WebDriver driver;
    private WebDriverWait wait;
    private String urlTrangCanKiemTra = "https://olms.codedao.io.vn/academic/makeup-class";
    private int timeoutTrongGiay = 10;
    public PageAttendanceManagement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    //An Thu

    private By headerRow = By.xpath("//tr[contains(@class, 'MuiTableRow-head')]");
    private By statusColumnHeader = By.xpath("//th[.//span[text()='Trạng thái']]");
    private By firstStudentStatus = By.xpath("//tr[1]//td[5]//span[text()='Chưa điểm danh']");


    public boolean isElementDisplayed(By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return element.isDisplayed();
    }

    public By getHeaderRow() {
        return headerRow;
    }

    public By getStatusColumnHeader() {
        return statusColumnHeader;
    }

    public By getFirstStudentStatus() {
        return firstStudentStatus;
    }

    //Hoang Long
    public void GoToBoiBai(){
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//a[@href='/academic/makeup-class']")).click();
    }
    public void ClickBoiBai(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='TaskAltIcon'])[1]")).click();
    }
    public void ClickNghiTinhPhi(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='UnpublishedIcon'])[1]")).click();

    }
    public void ClickNghiBaoLuu(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='DoNotDisturbOnIcon'])[1]")).click();

    }
    public void HoiBuoiDiemDanh(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='HistoryIcon'])[1]")).click();

    }
    public void kiemTraClickButtonDSBoiBai() {
        driver.get(urlTrangCanKiemTra);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutTrongGiay));

        // Tìm element <a> có thuộc tính href là '/academic/makeup-class'
        WebElement buttonDSBoiBai = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/academic/makeup-class']")));

        // Kiểm tra xem button có được hiển thị và có thể tương tác hay không
        Assert.assertTrue(buttonDSBoiBai.isDisplayed(), "Button 'DS Học viên bồi bài' không hiển thị.");
        Assert.assertTrue(buttonDSBoiBai.isEnabled(), "Button 'DS Học viên bồi bài' không được kích hoạt.");

        // Thực hiện click vào button
        buttonDSBoiBai.click();

        // Kiểm tra URL sau khi click
        String expectedUrlSauClick = "https://olms.codedao.io.vn/academic/makeup-class";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlSauClick, "Không chuyển đến đúng URL sau khi click.");
    }

    public void GoToDiemDanh(){
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//p[text()='Điểm danh']")).click();
    }
    public void DiemDanhVang(){
        driver.findElement(By.xpath("//tr/td[text()='Tùng Lâm - Tom']")).click();
        driver.findElement(By.xpath("//button/text()[normalize-space()='Điểm danh']/parent::button")).click();
        driver.findElement(By.xpath("//th[normalize-space()='Vắng mặt']//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[text()='Huỷ bỏ']")).click();
        //driver.findElement(By.xpath("//button[text()='Lưu']")).click();
    }
    public void DiemDanhBaoLuu(){
        driver.findElement(By.xpath("//tr/td[text()='Quỳnh Anh - Ami']")).click();
        driver.findElement(By.xpath("//button/text()[normalize-space()='Điểm danh']/parent::button")).click();
        driver.findElement(By.xpath("//th[normalize-space()='Nghỉ bảo lưu']//input[@class='PrivateSwitchBase-input css-1m9pwf3']")).click();
        //driver.findElement(By.xpath("//button[text()='Lưu']")).click();
    }
    public void DiemDanhCoMat(){
        driver.findElement(By.xpath("//tr/td[text()='Tùng Lâm - Tom']")).click();
        driver.findElement(By.xpath("//button/text()[normalize-space()='Điểm danh']/parent::button")).click();
        driver.findElement(By.xpath("//th[normalize-space()='Có mặt']//input[@class='PrivateSwitchBase-input css-1m9pwf3']")).click();
        //driver.findElement(By.xpath("//button[text()='Lưu']")).click();
    }
    public void CheckTieuDe(){
        WebElement tieuDeDiemDanh = driver.findElement(By.xpath("//h2[@id=':re:']"));
        String actualText = tieuDeDiemDanh.getText();
        String expectedText = "Điểm danh học viên";
        Assert.assertEquals(actualText, expectedText, "Tiêu đề 'Điểm danh học viên' không đúng. Text thực tế là: " + actualText);
    }

    //Xuan Hue
    public void ClickDenLichSuDiemDanh(){
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
    }

    public void TimKiemHV(){
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation1')]//li[@id='asynchronous-option-0']")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[3]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation1')]//li[@id='asynchronous-option-0']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiInputBase-formControl')]//div[(@id = 'student-status')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation')]//li[text() = 'Có mặt']")).click();
    }

    public void TimKiemHV1trong3ttsai(){
        driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-elevation1')]//li[@id='asynchronous-option-0']")).click();
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
