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
public class GhiDanhHocVien extends BaseTest {

    @Test(dataProvider = "bookingData")
    public void verifyGhiDanhHocVien(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.ClickDaoTao();

    }

    @Test(dataProvider = "bookingData")
    public void verifyGhiDanhHocVienKhongChonHV(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.ClickGhiDanhKhongChonHV();
        loginPage.verifyErrorMessageIsDisplayGhiDanh();

    }

    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel
    }

}