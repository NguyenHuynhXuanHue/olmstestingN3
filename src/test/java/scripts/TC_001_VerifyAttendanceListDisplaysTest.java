package scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AttendancePage;
import pages.DashboardPage;
import pages.LoginPage;
import listeners.TestListener;
import pages.LoginPage_Thu;

@Listeners(TestListener.class)
public class TC_001_VerifyAttendanceListDisplaysTest extends BaseTest_Thu {

    @Test
    public void testAttendanceListAutoDisplaysOnClassDay() {
        try {

            new LoginPage_Thu(driver).login("testadmin", "test1234");
            new DashboardPage(driver).goToAttendancePage();

            AttendancePage attendancePage = new AttendancePage(driver);
            Assert.assertTrue(
                    attendancePage.isElementDisplayed(attendancePage.getHeaderRow()),
                    "The attendance list header is not displayed"
            );

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed: " + e.getMessage());
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
