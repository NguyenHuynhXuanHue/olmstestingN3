package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewStudent {
    WebDriver driver;
    public AddNewStudent (WebDriver driver){
        this.driver = driver;
    }
    By newStudentCreation (WebDriver driver, String newStudent){
        return By.xpath("//p[text()='"+newStudent+"']");
    }

    By warningError = By.xpath("//h2[text()='Lỗi hệ thống']/ancestor::div[@role=\"dialog\"]");

    By inputBranch = By.xpath("//input[@value='OLMS 1']");

    By inputStatus = By.xpath("//div[text()='Kích hoạt']");

    By inputStudentLastname = By.xpath("//legend/span[text()='Họ và tên đệm']/ancestor::div[contains(@class, 'MuiInputBase-root')]//input");

    By inputStudentFirstName = By.xpath("//legend/span[text()='Tên']/ancestor::div[contains(@class, 'MuiInputBase-root')]//input");

    By inputEnglishName = By.xpath("//legend/span[text()='Tên tiếng Anh']/ancestor::div[contains(@class, 'MuiInputBase-root')]//input");

    By inputStudentBirthday = By.xpath("//legend/span[text()='Sinh nhật']/ancestor::div[contains(@class, 'MuiInputBase-root')]//input");

    By inputTestResult = By.xpath("//legend/span[text()='Kết quả test đầu vào']/ancestor::div[contains(@class, 'MuiInputBase-root')]//input");

    By introduceCombobox = By.xpath("//div[@role='combobox' and text()='Phụ huynh']");

        //Parent One
    ;
    By inputParentOne = By.xpath("//p[normalize-space()='Phụ huynh 1']/ancestor::div[@class='MuiGrid-root MuiGrid-container MuiGrid-item css-n6nfem']//input[@id='asynchronous']");

    By inputParentOneName = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1udg006']/div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-item css-1mia3zg\"][1]//label[normalize-space()='Tên PH']/ancestor::div[@class='MuiFormControl-root MuiFormControl-marginDense MuiFormControl-fullWidth MuiTextField-root css-1gat2ue']//input");

    By inputParentOnePhoneNumber = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1udg006']/div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-item css-1mia3zg\"][1]//label[normalize-space()='SĐT']/ancestor::div[@class='MuiFormControl-root MuiFormControl-marginDense MuiFormControl-fullWidth MuiTextField-root css-1gat2ue']//input");

    By inputParentlOneEmail = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1udg006']/div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-item css-1mia3zg\"][1]//label[normalize-space()='Email PH']/ancestor::div[@class='MuiFormControl-root MuiFormControl-marginDense MuiFormControl-fullWidth MuiTextField-root css-1gat2ue']//input");
        //Parent Two

    By inputParentTwo = By.xpath("//p[normalize-space()='Phụ huynh 2']/ancestor::div[@class='MuiGrid-root MuiGrid-container MuiGrid-item css-5imvyq']//input[@id='asynchronous']");

    By inputParentTwoName = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1udg006']/div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-item css-1mia3zg\"][2]//label[normalize-space()='Tên PH']/ancestor::div[@class='MuiFormControl-root MuiFormControl-marginDense MuiFormControl-fullWidth MuiTextField-root css-1gat2ue']//input");

    By inputParentTwoPhoneNumber = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1udg006']/div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-item css-1mia3zg\"][2]//label[normalize-space()='SĐT']/ancestor::div[@class='MuiFormControl-root MuiFormControl-marginDense MuiFormControl-fullWidth MuiTextField-root css-1gat2ue']//input");

    By inputParentTwoEmail = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1udg006']/div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-item css-1mia3zg\"][2]//label[normalize-space()='Email PH']/ancestor::div[@class='MuiFormControl-root MuiFormControl-marginDense MuiFormControl-fullWidth MuiTextField-root css-1gat2ue']//input");

    By studentCancelBtn = By.xpath("//button[text()='Huỷ bỏ']");

    By studentSaveBtn = By.xpath("//button[text()='Lưu']");

    public boolean isSBranchFieldEnable(){
        WebElement inputBranchField = driver.findElement(inputBranch);
        return inputBranchField.isEnabled();
    }

    public boolean isStatusFieldEnable(){
        WebElement inputStatusField = driver.findElement(inputStatus);
        return inputStatusField.isEnabled();
    }
    public boolean isErrorWarningDisplayed(){
        WebElement isErrorWarningDisplayed = driver.findElement(warningError);
        return isErrorWarningDisplayed.isDisplayed();
    }

    public boolean isNewStudentDisplayed(){
        return driver.findElement(newStudentCreation(driver, "Khanh")).isDisplayed();
    }

    public void clearStudentLastNameField(){
        driver.findElement(inputStudentLastname).clear();
    }
    public void enterStudentLastNameField(String studentLastName){
        driver.findElement(inputStudentLastname).sendKeys(studentLastName);
    }

    public  void clearStudentFirstNameField(){
        driver.findElement(inputStudentFirstName).clear();
    }
    public void enterStudentFirstNameField(String studentFirstName){
        driver.findElement(inputStudentFirstName).sendKeys(studentFirstName);
    }
    public String getStudentFirstName(){
        return driver.findElement(inputStudentFirstName).getText();
    }

    public void clearParentOneNameField(){
        driver.findElement(inputParentOneName).clear();
    }
    public  void enterParentNameOneField(String parentOneName){
        driver.findElement(inputParentOneName).sendKeys(parentOneName);
    }

    public void clearParentOnePhoneNumberField(){
        driver.findElement(inputParentOnePhoneNumber).clear();
    }
    public void enterParentOnePhoneNumberField(String ParentOnePhoneNumber){
        driver.findElement(inputParentOnePhoneNumber).sendKeys(ParentOnePhoneNumber);
    }

    public void clearParentOneEmailField(){
        driver.findElement(inputParentlOneEmail).clear();
    }
    public void enterParentEmailOneField(String parentOneEmail){
        driver.findElement(inputParentlOneEmail).sendKeys(parentOneEmail);
    }

    public void clearEnglishNameField(){
        driver.findElement(inputEnglishName).clear();
    }
    public void enterEnglishNameField(String englishName){
        driver.findElement(inputEnglishName).sendKeys(englishName);
    };

    public void clearStudentBirthdayField(){
        driver.findElement(inputStudentBirthday).clear();
    }
    public void enterStudentBirthdayField(String studentBirthday){
        driver.findElement(inputStudentBirthday).sendKeys(studentBirthday);
    }

    public void clearTestResultField(){
        driver.findElement(inputTestResult).clear();
    }
    public void enterTestResultField(String testResult){
        driver.findElement(inputTestResult).sendKeys(testResult);
    }

    public void clearParentTwoName(){
        driver.findElement(inputParentTwoName).clear();
    }

    public void clearParentTwoPhoneNumber(){
        driver.findElement(inputParentTwoPhoneNumber).clear();
    }

    public void clearParentTwoEmail(){
        driver.findElement(inputParentTwoEmail).clear();
    }
    public void introduceSource (){
        driver.findElement(introduceCombobox).click();
    }

    public void clickStudentCancelBtn (){
        driver.findElement(studentCancelBtn).click();
    }

    public void clickStudentSaveBtn (){
        driver.findElement(studentSaveBtn).click();
    }
}
