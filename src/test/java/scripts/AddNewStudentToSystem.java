package scripts;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddNewStudent;
import pages.HomePage;
import pages.LoginPage;


public class AddNewStudentToSystem extends BaseTest {
    @BeforeMethod
    public void setUpCheckAddStudentFunction() {
        Actions action = new Actions(driver);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("testadmin");
        loginPage.inputPassword("test1234");
        loginPage.clickLoginBtn();

        HomePage homePage = new HomePage(driver);
        homePage.clickTraingBtn();
        homePage.clickStudentListBtn();
        homePage.clickCreateStudentBtn();
    }
    @Test
        public void TC001_isStudentLastNameFieldRequired(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);
        addNewStudent.clickStudentSaveBtn();
        Assert.assertTrue(addNewStudent.isErrorWarningDisplayed(),"Last Name field is not required!");
    }

    @Test
         public void TC002_isStudentFirstNameFieldRequired(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);
        addNewStudent.clickStudentSaveBtn();
        Assert.assertTrue(addNewStudent.isErrorWarningDisplayed(),"First Name field is not required!");
    }

    @Test
        public void TC003_isParentOneNameFieldRequired(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);
        addNewStudent.clickStudentSaveBtn();
        Assert.assertTrue(addNewStudent.isErrorWarningDisplayed(),"Parent Name One field is not required");
    }

    @Test
        public void TC004_isParentOnePhoneNumberFieldRequired(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);
        addNewStudent.clickStudentSaveBtn();
        Assert.assertTrue(addNewStudent.isErrorWarningDisplayed(),"Parent One Phone Number field is not required");
    }

    @Test
        public void TC005_isParentOneEmailFieldRequired(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);
        addNewStudent.clickStudentSaveBtn();
        Assert.assertTrue(addNewStudent.isErrorWarningDisplayed(),"Parent One Mail field is not required");
    }

    @Test
    public void TC006_checkAddNewStudentFunctionWithoutLastNameField(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);

//        addNewStudent.enterStudentLastNameField("Nguyen");
        addNewStudent.enterStudentFirstNameField("Trang");
        addNewStudent.enterParentNameOneField("Nguyen Hung");
        addNewStudent.enterParentOnePhoneNumberField("0909123456");
        addNewStudent.enterParentEmailOneField("hungnguyen@gmail.com");

        addNewStudent.clickStudentSaveBtn();

        addNewStudent.isErrorWarningDisplayed();
    }

    @Test
    public void TC007_checkAddNewStudentFunctionWithoutFirstNameField(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);

        addNewStudent.enterStudentLastNameField("Nguyen");
//        addNewStudent.enterStudentFirstNameField("Trang");
        addNewStudent.enterParentNameOneField("Nguyen Hung");
        addNewStudent.enterParentOnePhoneNumberField("0909123456");
        addNewStudent.enterParentEmailOneField("hungnguyen@gmail.com");

        addNewStudent.clickStudentSaveBtn();

        addNewStudent.isErrorWarningDisplayed();
    }

    @Test
    public void TC008_checkAddNewStudentFunctionWithoutParentOneNameField(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);

        addNewStudent.enterStudentLastNameField("Nguyen");
        addNewStudent.enterStudentFirstNameField("Trang");
//        addNewStudent.enterParentNameOneField("Nguyen Hung");
        addNewStudent.enterParentOnePhoneNumberField("0909123456");
        addNewStudent.enterParentEmailOneField("hungnguyen@gmail.com");

        addNewStudent.clickStudentSaveBtn();

        addNewStudent.isErrorWarningDisplayed();
    }

    @Test
    public void TC009_checkAddNewStudentFunctionWithoutParentOnePhoneNumberField(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);

        addNewStudent.enterStudentLastNameField("Nguyen");
        addNewStudent.enterStudentFirstNameField("Trang");
        addNewStudent.enterParentNameOneField("Nguyen Hung");
//        addNewStudent.enterParentOnePhoneNumberField("0909123456");
        addNewStudent.enterParentEmailOneField("hungnguyen@gmail.com");

        addNewStudent.clickStudentSaveBtn();

        addNewStudent.isErrorWarningDisplayed();
    }

    @Test
    public void TC010_checkAddNewStudentFunctionWithoutParentOneEmailField(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);

        addNewStudent.enterStudentLastNameField("Nguyen");
        addNewStudent.enterStudentFirstNameField("Trang");
        addNewStudent.enterParentNameOneField("Nguyen Hung");
        addNewStudent.enterParentOnePhoneNumberField("0909123456");
//        addNewStudent.enterParentEmailOneField("hungnguyen@gmail.com");

        addNewStudent.clickStudentSaveBtn();

        addNewStudent.isErrorWarningDisplayed();
    }

  @Test
  public  void TC011_checkAddStudentWithFulfilledRequiredFields(){
      AddNewStudent addNewStudent = new AddNewStudent(driver);

      addNewStudent.enterStudentLastNameField("Nguyen");
      addNewStudent.enterStudentFirstNameField("Trang");
      addNewStudent.enterParentNameOneField("Nguyen Hung");
      addNewStudent.enterParentOnePhoneNumberField("0909123456");
      addNewStudent.enterParentEmailOneField("hungnguyen@gmail.com");

      addNewStudent.clickStudentSaveBtn();

      addNewStudent.isErrorWarningDisplayed();
    }
    @Test
    public void TC012_checkAddParentOneFromSystem(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);
    }

    @Test
    public void TC013_isBranchFieldEnable(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);
        addNewStudent.isSBranchFieldEnable();
        Assert.assertFalse(addNewStudent.isSBranchFieldEnable(),"Branch field is enable!");
    }

    @Test
    public void TC014_isStatusFieldEnable(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);
        addNewStudent.isStatusFieldEnable();
        Assert.assertFalse(addNewStudent.isStatusFieldEnable(),"Status field is enable!");
    }

    @Test
    public void TC015_checkStudentSaveBtn(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);

        addNewStudent.enterStudentLastNameField("Nguyen");
        addNewStudent.enterStudentFirstNameField("Trang");
        addNewStudent.enterParentNameOneField("Nguyen Hung");
        addNewStudent.enterParentOnePhoneNumberField("0909123456");
        addNewStudent.enterParentEmailOneField("hungnguyen@gmail.com");

        addNewStudent.clickStudentSaveBtn();

        Assert.assertTrue(addNewStudent.isNewStudentDisplayed(),"Create new student unsuccessfully");
    }

    @Test
    public void TC016_checkStudentCancelBtn(){
        AddNewStudent addNewStudent = new AddNewStudent(driver);

        addNewStudent.enterStudentLastNameField("Nguyen");
        addNewStudent.enterStudentFirstNameField("Khanh");
        addNewStudent.enterParentNameOneField("Nguyen Hung");
        addNewStudent.enterParentOnePhoneNumberField("0909123456");
        addNewStudent.enterParentEmailOneField("hungnguyen@gmail.com");

        addNewStudent.clickStudentCancelBtn();

        Assert.assertFalse(addNewStudent.isNewStudentDisplayed(),"New student information still saved when clicking cancel button!");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

