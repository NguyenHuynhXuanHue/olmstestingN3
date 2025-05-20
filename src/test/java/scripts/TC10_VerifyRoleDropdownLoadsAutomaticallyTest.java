package scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.LoginPage_Thu;

public class TC10_VerifyRoleDropdownLoadsAutomaticallyTest extends BaseTest_Thu {

    @Test
    public void testRoleDropdownLoadsWhenDepartmentIsSelected() {

        new LoginPage_Thu(driver).login("testadmin", "test1234");
        new DashboardPage(driver).goToEmployeePage();

        new AddEmployeePage(driver)
                .clickAddEmployeeButton()
                .selectDepartment("Văn phòng")
                .verifyOfficeRolesLoaded();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}