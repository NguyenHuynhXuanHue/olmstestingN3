package scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.LoginPage_Thu;

public class TC14_LoginAsOfficeEmployeeTest extends BaseTest_Thu {

    @Test
    public void testLoginSuccess() {

        new LoginPage_Thu(driver).login("thutest1234", "thutest1234");
        boolean isUserLoggedIn = new DashboardPage(driver).isUserLoggedIn();

        Assert.assertTrue(isUserLoggedIn, "Login failed. User info not visible");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
