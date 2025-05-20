package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class EditStaffPage {
    WebDriver driver;

    public EditStaffPage (WebDriver driver){
        this.driver = driver;
    }

    By editBtn (WebDriver driver, String indexStaff){
        return By.xpath("//td[text()='"+indexStaff+"']/ancestor::tr//button/*[@data-testid='EditIcon']");
    }

    By editScreen = By.xpath("//div[@role='presentation' and @class=\"MuiDialog-root MuiModal-root css-1glo1el\"]");

    By inputStaffLastName = By.xpath("//legend/span[text()='Họ và tên đệm']/ancestor::div[contains(@class, 'MuiInputBase-root')]/input");

    By inputStaffFirstName = By.xpath("//legend/span[text()='Tên']/ancestor::div[contains(@class, 'MuiInputBase-root')]/input");

    By inputStaffBirthday = By.xpath("//legend/span[text()='Ngày sinh']/ancestor::div[contains(@class, 'MuiInputBase-root')]/input");

    By officeCbx = By.xpath("//span[@class=\"MuiButtonBase-root MuiRadio-root MuiRadio-colorPrimary Mui-disabled PrivateSwitchBase-root MuiRadio-root MuiRadio-colorPrimary Mui-checked Mui-disabled MuiRadio-root MuiRadio-colorPrimary css-1ueqmp3\"]");

    By trainingCbx = By.xpath("//span[@class=\"MuiButtonBase-root MuiRadio-root MuiRadio-colorPrimary Mui-disabled PrivateSwitchBase-root MuiRadio-root MuiRadio-colorPrimary Mui-disabled MuiRadio-root MuiRadio-colorPrimary css-1ueqmp3\"]");

    By inputStartDay = By.xpath("//legend/span[text()='Ngày bắt đầu làm việc']/ancestor::div[contains(@class, 'MuiInputBase-root')]/input");

    By inputContractLink = By.xpath("//legend/span[text()='Link Hợp đồng']/ancestor::div[contains(@class, 'MuiInputBase-root')]/input");

    By inputStaffUserName = By.xpath("//legend/span[text()='Tên đăng nhập / Tài khoản']/ancestor::div[contains(@class, 'MuiInputBase-root')]/input");

    By inputStaffPwd = By.xpath("//legend/span[text()='Mật khẩu']/ancestor::div[contains(@class, 'MuiInputBase-root')]/input");

    By inputStaffPhoneNumber = By.xpath("//legend/span[text()='SĐT']/ancestor::div[contains(@class, 'MuiInputBase-root')]/input");

    By staffCancelBtn = By.xpath("//button[text()='Huỷ bỏ']");

    By staffconfirmBtn = By.xpath("//button[text()='Xác nhận']");

    public void clickEditBtn (String indexStaff){
        driver.findElement(editBtn(driver, indexStaff)).click();
    }

    public boolean isEditScreenDisplayed() {
        return driver.findElements(editScreen).size()>0;
    }

    //last name field
    public void clearStaffLastName (){
        driver.findElement(inputStaffLastName).clear();
    }
    public void enterStaffLastName (String staffLastName){
        driver.findElement(inputStaffLastName).sendKeys(staffLastName);
    }
    public String getStaffLastName(){
        return driver.findElement(inputStaffLastName).getText();
    }

    //first name field
    public void enterStaffFirstName (String staffFristName){
        driver.findElement(inputStaffFirstName).sendKeys(staffFristName);
    }
    public void clearStaffFirstName (){
        driver.findElement(inputStaffFirstName).clear();
    }
    public String getStaffFristName(){
        return driver.findElement(inputStaffFirstName).getText();
    }

    //birthday field
    public void clearStaffBirthday(){
        driver.findElement(inputStaffBirthday).clear();
    }
    public void enterStaffBirthday(String staffBirthday){
        driver.findElement(inputStaffBirthday).sendKeys(staffBirthday);
    }
    public boolean isBirthdayFieldEnable(){
        WebElement isBirthdayFieldEnable = driver.findElement(inputStaffBirthday);
        return isBirthdayFieldEnable.isEnabled();
    }
    public String getStaffBirthday(){
       return driver.findElement(inputStaffBirthday).getText();
    }

    public boolean isOfficeCbxEnable (){
        WebElement isOfficeCbxEnable = driver.findElement(officeCbx);
        return isOfficeCbxEnable.isEnabled();
    }

    public boolean isTraingCbxEnable(){
        driver.findElement(trainingCbx).isEnabled();
        WebElement isTraniningCbxEnable = driver.findElement(trainingCbx);
        return isTraniningCbxEnable.isEnabled();
    }

    //starting day field
    public void clearStartDay(){
        driver.findElement(inputStartDay).clear();
    }
    public void enterStartDay(String staffStartDay){
        driver.findElement(inputStartDay).sendKeys(staffStartDay);
    }
    public boolean isStartDayEnable(){
        WebElement isStartDayEnable = driver.findElement(inputStartDay);
        return isStartDayEnable.isEnabled();
    }
    public String getStartDay(){
        return driver.findElement(inputStartDay).getText();
    }

    //contract link field
    public void clearContractLink(){
        driver.findElement(inputContractLink).clear();
    }
    public void enterContractLink(String staffContractLink){
        driver.findElement(inputContractLink).sendKeys(staffContractLink);
    }
    public boolean isContractLinkEnable(){
        WebElement isContractLinkEnable = driver.findElement(inputContractLink);
        return isContractLinkEnable.isEnabled();
    }
    public String getContractLink(){
        return driver.findElement(inputContractLink).getText();
    }

    //username field
    public void enterStaffUserName (String staffUserName){
        driver.findElement(inputStaffUserName).clear();
        driver.findElement(inputStaffUserName).sendKeys(staffUserName);
    }
    public boolean isStaffUserNameFieldEnable(){
        WebElement isStaffUserNameFieldEnable = driver.findElement(inputStaffUserName);
        return isStaffUserNameFieldEnable.isEnabled();
    }
    public String getStaffUserName(){
        return driver.findElement(inputStaffUserName).getText();
    }

    //pwd field
    public void clearStaffPwd(){
        driver.findElement(inputStaffPwd).clear();
    }
    public void enterStaffPwd (String staffPwd){

        driver.findElement(inputStaffPwd).sendKeys(staffPwd);
    }
    public String getStaffPwd (){
        return driver.findElement(inputStaffPwd).getText();
    }

    //phonenumber field
    public void enterStaffPhoneNumber (String staffPhoneNumber){
        driver.findElement(inputStaffPhoneNumber).sendKeys(staffPhoneNumber);
    }
    public void clearStaffPhoneNumber(){
       WebElement clearStaffPhoneNumber =  driver.findElement(inputStaffPhoneNumber);
       clearStaffPhoneNumber.clear();
    }
    public String getStaffPhoneNumber(){
        return driver.findElement(inputStaffPhoneNumber).getText();
    }
    public void clickStaffCancelBtn (){
        driver.findElement(staffCancelBtn).click();
    }

    public void clickStaffConfirmBtn(){
        driver.findElement(staffconfirmBtn).click();
    }

    public boolean isStaffConfirmBtnEnable(){
        WebElement isStaffConfirmBtnEnalble = driver.findElement(staffconfirmBtn);
        return isStaffConfirmBtnEnalble.isEnabled();
    }


}
