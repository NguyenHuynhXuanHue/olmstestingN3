package scripts;


import ObjectRepository.webS;
import listeners.SimpleListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import ultilities.ExtentHelper;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Listeners(SimpleListener.class)
public class Attendancemanagement extends BaseTest {

    @BeforeMethod
    public void setupTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAdmin();
    }

    //AN THU (khi chạy 2 test, ẩm @BeforeMethod)
   /* @Test
    public void TC_001_VerifyAttendanceListDisplaysTest() {
        try {
            new LoginPage(driver).login("testadmin", "test1234");

            new DashboardPage(driver).goToAttendancePage();

            PageAttendanceManagement attendancePage = new PageAttendanceManagement(driver);

            Assert.assertTrue(
                    attendancePage.isElementDisplayed(attendancePage.getHeaderRow()),
                    "The attendance list header is not displayed"
            );

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_002_VerifyDefaultAttendanceStatusTest() {
        try {
            new LoginPage(driver).login("testadmin", "test1234");

            new DashboardPage(driver).goToAttendancePage();

            PageAttendanceManagement attendancePage = new PageAttendanceManagement(driver);

            Assert.assertTrue(
                    attendancePage.isElementDisplayed(attendancePage.getStatusColumnHeader()),
                    "The column header 'Status' is not displayed"
            );

            Assert.assertTrue(
                    attendancePage.isElementDisplayed(attendancePage.getFirstStudentStatus()),
                    "The student status is not 'Not Marked as Present'"
            );

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed: " + e.getMessage());
        }
    }*/


    //HOANG LONG
    @Test
    public void KiemTraNutDanhSachHocVienBoiBai() {
        PageAttendanceManagement bb = new PageAttendanceManagement(driver);
        bb.GoToBoiBai();
        bb.kiemTraClickButtonDSBoiBai();
    }

    @Test
    public void kiemTraChuyenTrangSauKhiNhanVaoDSBoiBai() {
        PageAttendanceManagement bb = new PageAttendanceManagement(driver);
        bb.GoToBoiBai();
        String expectedUrl = "https://olms.codedao.io.vn/academic/makeup-class"; // Lấy URL chính xác của trang
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Không đúng trang bồi bài. URL thực tế: " + actualUrl);
    }
    @Test
    public void kiemTraDanhDauDaBoiBai() {

        PageAttendanceManagement bb = new PageAttendanceManagement(driver);
        bb.GoToBoiBai();
        bb.ClickBoiBai();
    }
    @Test
    public void kiemTraDanhDauNghiTinhPhi() {
        PageAttendanceManagement bb = new PageAttendanceManagement(driver);
        bb.GoToBoiBai();
        bb.ClickNghiTinhPhi();
    }
    @Test
    public void kiemTraDanhDauNghiBaoLuu() {
        PageAttendanceManagement bb = new PageAttendanceManagement(driver);
        bb.GoToBoiBai();
        bb.ClickNghiBaoLuu();
    }
    @Test
    public void kiemTraClickHoiBuoiDiemDanh() {
        PageAttendanceManagement bb = new PageAttendanceManagement(driver);
        bb.GoToBoiBai();
        bb.HoiBuoiDiemDanh();
    }

    @Test
    public void KiemTraChucNangBTNDiemDanh() {
        PageAttendanceManagement dd = new PageAttendanceManagement(driver);
        dd.GoToDiemDanh();
        dd.DiemDanhBaoLuu();
        dd.CheckTieuDe();
    }
    @Test
    public void KiemTraDanhSachKhiDiemDanhVang() {
        PageAttendanceManagement dd = new PageAttendanceManagement(driver);
        dd.GoToDiemDanh();
        dd.DiemDanhVang();
        driver.findElement(By.xpath("//a[@href='/academic/makeup-class']")).click();
        // Kiểm tra sự tồn tại của "Tùng Lâm - Tom"
        By tungLamTomLocator = By.xpath("//td[text()='Tùng Lâm - Tom']");
        Assert.assertTrue(isElementVisible(tungLamTomLocator), "Thành phần 'Tùng Lâm - Tom' không hiển thị trên trang sau " + 1 + " giây.");

        // Kiểm tra sự tồn tại của "Sunny 66"
        By sunny66Locator = By.xpath("//td[text()='Sunny 66']");
        Assert.assertTrue(isElementVisible(sunny66Locator), "Thành phần 'Sunny 66' không hiển thị trên trang sau " + 1 + " giây.");

        // Kiểm tra sự tồn tại của "12/05/2025"
        By ngayThangLocator = By.xpath("//td[text()='12/05/2025']");
        Assert.assertTrue(isElementVisible(ngayThangLocator), "Thành phần '12/05/2025' không hiển thị trên trang sau " + 1 + " giây.");
    }


    private boolean isElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    //XUAN HUE
    @Test
    public void TC005verifyTKLSDiemDanhHV() {
        Actions actions = new Actions(driver);
        PageAttendanceManagement pageQLDiemDanh = new PageAttendanceManagement(driver);

        pageQLDiemDanh.ClickDenLichSuDiemDanh();
        WebElement lich_su = driver.findElement(By.xpath("//p[text()='Lịch sử điểm danh']"));
        actions.moveToElement(lich_su).perform();
        lich_su.click();
        WebElement input = driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[1]"));
        actions.moveToElement(input).click().perform();
        pageQLDiemDanh.TimKiemHV();

    }

    @Test
    public void TC006verifyTKLSDiemDanhHV1trong3TTKoHL() {
        Actions actions = new Actions(driver);
        PageAttendanceManagement pageQLDiemDanh = new PageAttendanceManagement(driver);

        pageQLDiemDanh.ClickDenLichSuDiemDanh();
        WebElement lich_su = driver.findElement(By.xpath("//p[text()='Lịch sử điểm danh']"));
        actions.moveToElement(lich_su).perform();
        lich_su.click();
        WebElement input = driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[1]"));
        actions.moveToElement(input).click().perform();
        pageQLDiemDanh.TimKiemHV1trong3ttsai();

    }

    @Test
    public void TC007verifyinputTKtheoGV() {
        Actions actions = new Actions(driver);
        PageAttendanceManagement pageQLDiemDanh = new PageAttendanceManagement(driver);

        pageQLDiemDanh.ClickDenLichSuDiemDanh();
        WebElement lich_su = driver.findElement(By.xpath("//p[text()='Lịch sử điểm danh']"));
        actions.moveToElement(lich_su).perform();
        lich_su.click();
        WebElement input = driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[1]"));
        actions.moveToElement(input).click().perform();
        pageQLDiemDanh.TimKiemTheoGV();

    }
    @Test
    public void TC009verifyHienThiSumHVvaCacTrangThai() {
        Actions actions = new Actions(driver);
        LoginPage messageerror = new LoginPage(driver);
        PageAttendanceManagement pageQLDiemDanh = new PageAttendanceManagement(driver);

        pageQLDiemDanh.ClickDenLichSuDiemDanh();
        WebElement lich_su = driver.findElement(By.xpath("//p[text()='Lịch sử điểm danh']"));
        actions.moveToElement(lich_su).perform();
        lich_su.click();
        messageerror.TC009TCQLDiemDanhHV();
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}