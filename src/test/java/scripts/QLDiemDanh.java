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
public class QLDiemDanh extends BaseTest {

    @Test(dataProvider = "olms")
    public void TC005verifyTKLSDiemDanhHV(String username, String password) {
        Actions actions = new Actions(driver);
        LoginPage loginPage = new LoginPage(driver);
        PageQLDiemDanh pageQLDiemDanh = new PageQLDiemDanh(driver);

        loginPage.login(username, password);
        pageQLDiemDanh.ClickDenLichSuDiemDanh();
        WebElement lich_su = driver.findElement(By.xpath("//p[text()='Lịch sử điểm danh']"));
        actions.moveToElement(lich_su).perform();
        lich_su.click();
        WebElement input = driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[1]"));
        actions.moveToElement(input).click().perform();
        pageQLDiemDanh.TimKiemHV();

    }

    @Test(dataProvider = "olms")
    public void TC006verifyTKLSDiemDanhHV1trong3TTKoHL(String username, String password) {
        Actions actions = new Actions(driver);
        LoginPage loginPage = new LoginPage(driver);
        PageQLDiemDanh pageQLDiemDanh = new PageQLDiemDanh(driver);

        loginPage.login(username, password);
        pageQLDiemDanh.ClickDenLichSuDiemDanh();
        WebElement lich_su = driver.findElement(By.xpath("//p[text()='Lịch sử điểm danh']"));
        actions.moveToElement(lich_su).perform();
        lich_su.click();
        WebElement input = driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[1]"));
        actions.moveToElement(input).click().perform();
        pageQLDiemDanh.TimKiemHV1trong3ttsai();

    }

    @Test(dataProvider = "olms")
    public void TC007verifyinputTKtheoGV(String username, String password) {
        Actions actions = new Actions(driver);
        LoginPage loginPage = new LoginPage(driver);
        PageQLDiemDanh pageQLDiemDanh = new PageQLDiemDanh(driver);

        loginPage.login(username, password);
        pageQLDiemDanh.ClickDenLichSuDiemDanh();
        WebElement lich_su = driver.findElement(By.xpath("//p[text()='Lịch sử điểm danh']"));
        actions.moveToElement(lich_su).perform();
        lich_su.click();
        WebElement input = driver.findElement(By.xpath("(//div[contains(@class, 'MuiAutocomplete')]//button[@title='Open'])[1]"));
        actions.moveToElement(input).click().perform();
        pageQLDiemDanh.TimKiemTheoGV();

    }
    @Test(dataProvider = "olms")
    public void TC009verifyHienThiSumHVvaCacTrangThai(String username, String password) {
        Actions actions = new Actions(driver);
        LoginPage loginPage = new LoginPage(driver);
        PageQLDiemDanh pageQLDiemDanh = new PageQLDiemDanh(driver);

        loginPage.login(username, password);
        pageQLDiemDanh.ClickDenLichSuDiemDanh();
        WebElement lich_su = driver.findElement(By.xpath("//p[text()='Lịch sử điểm danh']"));
        actions.moveToElement(lich_su).perform();
        lich_su.click();
        loginPage.TC009TCQLDiemDanhHV();
    }


    @DataProvider(name = "olms")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}