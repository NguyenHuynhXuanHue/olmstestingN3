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
public class cinemaBookingFromHomeToolTest extends BaseTest {

    @Test(dataProvider = "bookingData")
    public void verifyBookingByHomeTool(String username, String password){

        LoginPage loginPage = new LoginPage(driver);
        //PurchasePage purchasePage = new PurchasePage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);
        //HomePage homePage = new HomePage(driver);




        //homePage.clickSignInButton();
        loginPage.login(username, password);
        pageQLclass.ClickDaoTao();


      /*  logger.info("Test Info");
        logger.warn("Test Warn");
        logger.debug("Test Debug");
        logger.error("Test Error");
        logger.fatal("Test Fatal");*/

//        homePage.selectFileSlotFromPanel("Raya","07-03-2022");
        /*homePage.verifyMovieIsMoana2(movieName);

        WebElement homeTool = driver.findElement(By.xpath(webS.homeTool));
        actions.scrollToElement(homeTool);
        WebElement filmPlayButton = driver
                .findElement(By.xpath("//div[@id='lichChieu']//button[contains(@class,'MuiFab-root')]"));
        actions.moveToElement(filmPlayButton).perform();*/

        //select Film
        /*homePage.selectHomeToolFilter("Phim", "HÀNH TRÌNH CỦA MOANA 2");
        homePage.selectHomeToolFilter("Rạp", "CGV - Aeon Bình Tân");*/
    }

    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel
    }

    /*@Test
    public void verifyLoginWithInvalidPassword() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickSignInButton();
        //Nhập username
        //click login button
        loginPage.login("huydao226","");

        //Verify if there is error message displays
        loginPage.verifyErrorMessageIsDisplay();
    }*/

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

//    @DataProvider(name = "testings")
//    public Object[][] readUsers(){
//        return ExcelHelper.getExcelData("src/main/resources/users.xlsx", "TC001");
//    }
}