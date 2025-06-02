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
import org.testng.annotations.*;
import pages.*;
import ultilities.ExtentHelper;

import java.util.HashMap;
import java.util.Map;

@Listeners(SimpleListener.class)
public class ClassroomManagement extends BaseTest {

    @BeforeMethod
    public void setupTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAdmin();
    }

    @Test
    public void verifyGhiDanhHVKhTC004ongChonHV(){
        LoginPage messageerror = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        pageQLclass.ClickDenLop();
        pageQLclass.ClickGhiDanhKhongChonHV();
        messageerror.TC004verifyErrorMessageIsDisplay();

    }

    @Test
    public void TC006verifyGhiDanhHVChonThoiGianQK() {
        LoginPage messageerror = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        pageQLclass.ClickDenLop();
        pageQLclass.ClickDaoTao();
        messageerror.TC006verifyErrorMessageIsDisplay();
    }

    @Test
    public void TC010verifyTangGiamSoBuoiGiaTriKhongHLSo(){
        LoginPage messageerror = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        pageQLclass.ClickDenLop();
        pageQLclass.ClickTangGiamSoBuoi();
        messageerror.TC0010verifyErrorMessageIsDisplay();

    }

    @Test
    public void TC011verifyTangGiamSoBuoiGiaTriKhongHLChu(){
        LoginPage messageerror = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        pageQLclass.ClickDenLop();
        pageQLclass.ClickTangGiamSoBuoiChu();
        messageerror.TC0010verifyErrorMessageIsDisplay();

    }

    @Test
    public void TC013verifyChuyenLopTTKhongHL(){
        LoginPage messageerror = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        pageQLclass.ClickDenLop();
        pageQLclass.ChuyenLopSoBuoiAm();
        messageerror.TC0013verifyErrorMessageIsDisplay();

    }

    @Test
    public void TC020verifyBaoNghiNgayKoHL(){
        LoginPage messageerror = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        pageQLclass.ClickDenLop();
        pageQLclass.BaoNghi();
        messageerror.TC0020verifyErrorMessageIsDisplay();
    }

    @Test
    public void TC016verifyBaoLuuThongTinKhongHL(){
        LoginPage messageerror = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        pageQLclass.ClickDenLop();
        pageQLclass.BaoLuu();
        messageerror.TC0016verifyErrorMessageIsDisplay();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}