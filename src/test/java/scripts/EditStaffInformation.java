package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EditStaffPage;
import pages.HomePage;
import pages.LoginPage;

public class EditStaffInformation extends BaseTest{
    @BeforeMethod
    public void setup(){
        Actions action = new Actions(driver);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("testadmin");
        loginPage.inputPassword("test1234");
        loginPage.clickLoginBtn();

        HomePage homePage = new HomePage(driver);
        homePage.clickSettingBtn();
        homePage.clickManageStaffBtn();

        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.clickEditBtn("2");

    }

    @Test
    public void TC001_VerifyEditScreenDisplayed() {
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        boolean isDisplayed = editStaffPage.isEditScreenDisplayed();
        Assert.assertTrue(isDisplayed, "Edit popup is not displaed.");
    }

    @Test
    public void TC002_CheckLastNameFieldRequired(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.clearStaffLastName();
        editStaffPage.clickStaffConfirmBtn();
        Assert.assertFalse(editStaffPage.isStaffConfirmBtnEnable(),"Staff last name field is not required");
    }

    @Test
    public void TC003_CheckFirstNameFieldRequired(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.clearStaffFirstName();
        editStaffPage.clickStaffConfirmBtn();
        Assert.assertFalse(editStaffPage.isStaffConfirmBtnEnable(),"Staff first name field is not required!");
    }

    @Test
    public void TC004_CheckPhoneNumberFieldRequired(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.clearStaffPhoneNumber();
        editStaffPage.clickStaffConfirmBtn();
        Assert.assertFalse(editStaffPage.isStaffConfirmBtnEnable()," Staff phone number field is not required!");
    }

    @Test
    public void TC005_CheckUserNameFieldEnable(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.isStaffUserNameFieldEnable();
        Assert.assertFalse(editStaffPage.isStaffUserNameFieldEnable(),"Staff user name field is enable!");
    }

    @Test
    public void TC006_CheckEditStaffInformation(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);

        editStaffPage.clearStaffLastName();
        editStaffPage.enterStaffLastName("Nguyen");

        editStaffPage.clearStaffFirstName();
        editStaffPage.enterStaffFirstName("Trang");

        editStaffPage.clearStaffPhoneNumber();
        editStaffPage.enterStaffPhoneNumber("0909819101");

        Assert.assertFalse(editStaffPage.isStaffUserNameFieldEnable(),"Staff user name field is enable!");

        editStaffPage.clickStaffConfirmBtn();
    }

    @Test
        public void TC007_CheckOfficeCbxEnable(){
            EditStaffPage editStaffPage = new EditStaffPage(driver);
            editStaffPage.isOfficeCbxEnable();
            Assert.assertFalse(editStaffPage.isOfficeCbxEnable(),"Office checkbox is enable");
    }

    @Test
        public void TC008_CheckTrainingCbxEnable(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.isTraingCbxEnable();
        Assert.assertFalse(editStaffPage.isTraingCbxEnable(),"Traning check box is enable");
    }

    //TC 009,10,11,12 chua lam
    @Test
         public void TC013_IsBirthdayFieldOptional(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.isBirthdayFieldEnable();
        Assert.assertTrue(editStaffPage.isBirthdayFieldEnable(),"Birthday field is not enable");
}
    @Test
        public void TC014_IsStartDayFieldOptional(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.isStartDayEnable();
        Assert.assertTrue(editStaffPage.isStartDayEnable(),"Start day field is not enable");
    }
    @Test
        public void TC015_IsContractLinkFieldOptional(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.isContractLinkEnable();
        Assert.assertTrue(editStaffPage.isContractLinkEnable(),"Contract Link field is not enable");
    }
    @Test
    public void TC016_checkPwdTheSameWithUserName(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);

        String userName = editStaffPage.getStaffUserName();

        editStaffPage.clearStaffPwd();
        editStaffPage.enterStaffPwd(userName);
        String newPwd = editStaffPage.getStaffPwd();

        editStaffPage.clickStaffConfirmBtn();

        Assert.assertNotEquals(userName, newPwd,"User name and pwd should be different!");
    }

    @Test
    public void TC017_checkPwdTheSameWithPhoneNumber(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);

        String staffPhoneNumber = editStaffPage.getStaffPhoneNumber();

        editStaffPage.clearStaffPwd();
        editStaffPage.enterStaffPwd(staffPhoneNumber);
        String newPwdEqualToPhoneNumber = editStaffPage.getStaffPwd();

        editStaffPage.clickStaffConfirmBtn();

        Assert.assertNotEquals(staffPhoneNumber,newPwdEqualToPhoneNumber,"Phone number and pwd should be different!");
    }
    @Test
    public void TC19(){}

    @Test
    public void TC018_checkPwdTheSameWithStaffFullName(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);

        String staffLastName = editStaffPage.getStaffLastName();
        String staffFristName = editStaffPage.getStaffFristName();
        String staffFullName = staffLastName + staffFristName;

        editStaffPage.clearStaffPwd();
        editStaffPage.enterStaffPwd(staffFullName);
        String newPwdEqualToStaffFullName = editStaffPage.getStaffPwd();

        editStaffPage.clickStaffConfirmBtn();

        Assert.assertNotEquals(staffFullName,newPwdEqualToStaffFullName,"Fullname and pwd should be different!");
    }

    @Test
         public void TC020_checkConfirmBtn(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);

            //change required fields

        //last name field
        editStaffPage.clearStaffLastName();
        editStaffPage.enterStaffLastName("Nguyen");

        //first name field
        editStaffPage.clearStaffLastName();
        editStaffPage.enterStaffFirstName("Trang");

        //phone number field
        editStaffPage.clearStaffPhoneNumber();
        editStaffPage.enterStaffPhoneNumber("0909123456");

            //change optional field

        //birthday field
        editStaffPage.clearStaffBirthday();
        editStaffPage.enterStaffBirthday("080595");

        //starting working field
        editStaffPage.clearStartDay();
        editStaffPage.enterStaffBirthday("20102020");

        //contract link field
        editStaffPage.clearContractLink();
        editStaffPage.enterContractLink("HD123");

            //click confirm btn
        editStaffPage.clickStaffConfirmBtn();

//            //return back to staff list page
//        driver.get("https://olms.codedao.io.vn/settings/staffs");

            //click edit btn to check updated information
//        editStaffPage.clickEditBtn("2");

        String updatedLastName = editStaffPage.getStaffLastName();
        String updatedFirstName = editStaffPage.getStaffFristName();
        String updatedPhoneNumber = editStaffPage.getStaffPhoneNumber();

        String updatedBirthday = editStaffPage.getStaffBirthday();
        String updatedWorkingDay = editStaffPage.getStartDay();
        String updatedContractLink = editStaffPage.getStaffBirthday();

            //comparation
        Assert.assertEquals(updatedLastName,"Nguyen","Wrong update!");
        Assert.assertEquals(updatedFirstName,"Trang","wrong update!");
        Assert.assertEquals(updatedPhoneNumber,"0909123456","wrong update!");
        Assert.assertEquals(updatedBirthday,"080595","wrong update!");
        Assert.assertEquals(updatedWorkingDay,"201020","wrong update!");
        Assert.assertEquals(updatedContractLink,"HD123","wrong update!");

}
    @Test
        public void TC021_checkCancelBtn(){
        EditStaffPage editStaffPage = new EditStaffPage(driver);
        editStaffPage.clickStaffCancelBtn();


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

