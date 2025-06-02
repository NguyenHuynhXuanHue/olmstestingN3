package scripts;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.LoginPage_Thu;


import java.util.UUID;


@Listeners(listeners.TestListener.class)
public class EmployeeManagementTests extends BaseTest_Thu{


    private LoginPage_Thu loginPage;
    private DashboardPage dashboardPage;
    private AddEmployeePage addEmployeePage;


    @BeforeClass
    public void setUpClass() {
        super.setUp();
    }


    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage_Thu(driver);
        dashboardPage = new DashboardPage(driver);
        addEmployeePage = new AddEmployeePage(driver);


        loginPage.login("testadmin", "test1234");
        dashboardPage.goToEmployeePage();
    }


    // TC01: Verify 'Add Employee' button is visible
    @Test
    public void TC01_AddEmployeeFormAccessTest() {
        boolean isButtonDisplayed = addEmployeePage.isAddEmployeeButtonDisplayed();
        Assert.assertTrue(isButtonDisplayed,
                "The 'Add Employee' button does not appear after accessing the Employee Management page");
    }


    // TC05: Verify duplicate usernames are handled correctly
    @DataProvider(name = "duplicateUsernameCases")
    public Object[][] provideUsernameCases() {
        return new Object[][]{
                {"thutestofficeduplicate", "Văn phòng", "Chăm sóc khách hàng", false},
                {"thutestacademicduplicate", "Đào tạo", "Giáo viên Việt Nam", false},
                {"thutestofficeduplicate", "Đào tạo", "Giáo viên Việt Nam", true}
        };
    }


    @Test(dataProvider = "duplicateUsernameCases")
    public void TC05_VerifyDuplicateUsernamePerDepartmentTest(String username, String department, String role, boolean shouldSucceed) {
        addEmployeePage.createEmployee("Thư", "Test", department, username, "Thutest123@!", "0123445678", role);


        boolean isFormClosed = addEmployeePage.isAddEmployeeFormClosed();


        if (shouldSucceed) {
            Assert.assertTrue(isFormClosed, "The employee is not created successfully as expected");
        } else {
            Assert.assertFalse(isFormClosed, "The form is closed, but a duplicate username should be rejected");


            if ("Văn phòng".equals(department)) {
                Assert.assertTrue(addEmployeePage.isUsernameExistWarningVisibleOffice(),
                        "Error message is not displayed when the username is duplicated in Office Department");
            } else if ("Đào tạo".equals(department)) {
                Assert.assertTrue(addEmployeePage.isUsernameExistWarningVisibleAcademic(),
                        "Error message is not displayed when the username is duplicated in Academic Department");
            }
        }
    }


    // TC07: Verify invalid passwords are rejected
    @DataProvider(name = "invalidPasswords")
    public Object[][] invalidPasswordData() {
        return new Object[][]{
                {"123"}, {"abc 123"}, {"pw "}
        };
    }


    @Test(dataProvider = "invalidPasswords")
    public void TC07_VerifyInvalidPasswordsRejectedTest(String password) {
        String randomUsername = "thutestinvalidpwd_" + UUID.randomUUID().toString().substring(0, 8);
        addEmployeePage.clickAddEmployeeButton()
                .waitForFormVisible()
                .fillRequiredFields("Thư", "Test", "Văn phòng", randomUsername, password, "0123455678")
                .selectRole("Chăm sóc khách hàng")
                .clickConfirm();


        boolean formClosed = addEmployeePage.isAddEmployeeFormClosed();
        Assert.assertFalse(formClosed, "Employee was created with invalid password: " + password);
    }


    // TC09: Verify password with personal info shows warning
    @DataProvider(name = "personalInfoPasswords")
    public Object[][] providePersonalInfoPasswords() {
        return new Object[][]{
                {"thutest", "thutest"},
                {"0876543200", "0876543200"},
                {"thutestpwdpersonalinfo", "thutestpwdpersonalinfo"}
        };
    }


    @Test(dataProvider = "personalInfoPasswords")
    public void TC09_VerifyPasswordWithPersonalInfoWarningTest(String username, String password) {
        addEmployeePage.clickAddEmployeeButton()
                .fillRequiredFields("Thư", "Test", "Văn phòng", username, password, "0123456678")
                .selectRole("Chăm sóc khách hàng")
                .clickConfirm();


        boolean isFormClosed = addEmployeePage.isAddEmployeeFormClosed();


        Assert.assertFalse(isFormClosed,
                "The form is closed with a password containing personal information: " + password);
    }


    // TC10: Verify role dropdown loads when department is selected
    @Test
    public void TC10_VerifyRoleDropdownLoadsAutomaticallyTest() {
        addEmployeePage.clickAddEmployeeButton()
                .selectDepartment("Văn phòng")
                .verifyOfficeRolesLoaded();
    }


    // TC14: Verify login success with office employee
    @Test
    public void TC14_LoginAsOfficeEmployeeTest() {
        new LoginPage(driver).login("thutest1234", "thutest1234");
        boolean isUserLoggedIn = new DashboardPage(driver).isUserLoggedIn();
        Assert.assertTrue(isUserLoggedIn, "Login failed. User info not visible");
    }
}
