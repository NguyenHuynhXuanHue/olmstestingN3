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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import ultilities.ExtentHelper;

import java.util.HashMap;
import java.util.Map;

@Listeners(SimpleListener.class)
public class QLLop extends BaseTest {

    @Test(dataProvider = "bookingData")
    public void TC004verifyGhiDanhHVKhongChonHV(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.ClickDenLop();
        pageQLclass.ClickGhiDanhKhongChonHV();
        loginPage.TC004verifyErrorMessageIsDisplay();

    }

    @Test(dataProvider = "bookingData")
    public void TC006verifyGhiDanhHVChonThoiGianQK(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.ClickDenLop();
        pageQLclass.ClickDaoTao();
        loginPage.TC006verifyErrorMessageIsDisplay();
    }

    @Test(dataProvider = "bookingData")
    public void TC010verifyTangGiamSoBuoiGiaTriKhongHLSo(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.ClickDenLop();
        pageQLclass.ClickTangGiamSoBuoi();
        loginPage.TC0010verifyErrorMessageIsDisplay();

    }

    @Test(dataProvider = "bookingData")
    public void TC011verifyTangGiamSoBuoiGiaTriKhongHLChu(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.ClickDenLop();
        pageQLclass.ClickTangGiamSoBuoiChu();
        loginPage.TC0010verifyErrorMessageIsDisplay();

    }

    @Test(dataProvider = "bookingData")
    public void TC013verifyChuyenLopTTKhongHL(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.ClickDenLop();
        pageQLclass.ChuyenLopSoBuoiAm();
        loginPage.TC0013verifyErrorMessageIsDisplay();

    }

    @Test(dataProvider = "bookingData")
    public void TC020verifyBaoNghiNgayKhongHL(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.ClickDenLop();
        pageQLclass.BaoNghi();
        loginPage.TC0020verifyErrorMessageIsDisplay();
    }

    @Test(dataProvider = "bookingData")
    public void TC016verifyBaoLuuThongTinKhongHL(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.ClickDenLop();
        pageQLclass.BaoLuu();
        loginPage.TC0016verifyErrorMessageIsDisplay();
    }


    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}