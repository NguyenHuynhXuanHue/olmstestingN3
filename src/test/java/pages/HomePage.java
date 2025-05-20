package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By settingBtn = By.xpath("//span[text()='Cấu hình']/..");

    By manageStaffBtn = By.xpath("//a[@href=\"/settings/staffs\"]");

    By trainingBtn = By.xpath("//span[text()='Đào tạo']");

    By studentListBtn = By.xpath("//p[text()='DS Học viên']");

    By createStudentBtn = By.xpath("//button[normalize-space(text())='Tạo mới']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSettingBtn(){
        driver.findElement(settingBtn).click();
    }

    public void clickManageStaffBtn(){
        driver.findElement(manageStaffBtn).click();
    }

    public void clickTraingBtn(){
        driver.findElement(trainingBtn).click();
    }

    public void clickStudentListBtn(){
        driver.findElement(studentListBtn);
    }

    public void clickCreateStudentBtn(){
        driver.findElement(createStudentBtn);
    }
}
