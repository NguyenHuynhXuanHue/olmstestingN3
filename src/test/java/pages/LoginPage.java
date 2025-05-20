package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String pwd){
        driver.findElement(By.xpath("//input[@id='emailOrUsername']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void TC004verifyErrorMessageIsDisplay(){
        WebElement errorMsg = driver.findElement(By.xpath("//p[text()='The given id must not be null']"));
        Assert.assertEquals("The given id must not be null", errorMsg.getText());
    }

    public void TC006verifyErrorMessageIsDisplay(){
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='MuiDialogContent-root css-8qusvb']"));
        Assert.assertEquals("The given id must not be null", errorMsg.getText());
    }

    public void TC0010verifyErrorMessageIsDisplay(){
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='MuiDialogContent-root css-8qusvb']"));
        Assert.assertEquals("Enter a valid value with the number of registrations", errorMsg.getText());
    }


    public void TC0013verifyErrorMessageIsDisplay(){
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='MuiDialogContent-root css-8qusvb']"));
        Assert.assertEquals("Invalid class transfer information", errorMsg.getText());
    }

    public void TC0016verifyErrorMessageIsDisplay(){
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='MuiDialogContent-root css-8qusvb']"));
        Assert.assertEquals("invalid value", errorMsg.getText());
    }

    public void TC0020verifyErrorMessageIsDisplay(){
        WebElement errorMsg = driver.findElement(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 css-1mr6zkm']//div)[2]"));
        Assert.assertEquals("Allows to select the correct date", errorMsg.getText());
    }

    public void TC009TCQLDiemDanhHV(){
        WebElement StatusCM = driver.findElement(By.xpath("//div[contains(@class, '85kj67')]//p[starts-with(text(), 'Có mặt')]"));
        //Assert.assertEquals("Có mặt", Status.getText());
        Assert.assertTrue(StatusCM.getText().contains("Có mặt"));

        WebElement StatusVM = driver.findElement(By.xpath("//div[contains(@class, '85kj67')]//p[starts-with(text(), 'Vắng mặt')]"));
        Assert.assertTrue(StatusVM.getText().contains("Vắng mặt"));

        WebElement StatusNghiBaoLuu = driver.findElement(By.xpath("//div[contains(@class, '85kj67')]//p[starts-with(text(), 'Nghỉ bảo lưu')]"));
        Assert.assertTrue(StatusNghiBaoLuu.getText().contains("Nghỉ bảo lưu"));

        WebElement StatusChuaDiemDanh = driver.findElement(By.xpath("//div[contains(@class, '85kj67')]//p[starts-with(text(), 'Chưa điểm danh')]"));
        Assert.assertTrue(StatusChuaDiemDanh.getText().contains("Chưa điểm danh"));
    }

    //Phan Chi Trang
    public void inputUsername(String useraccount) {
        driver.findElement(By.id("emailOrUsername")).sendKeys(useraccount);
    }

    public void inputPassword(String pwd) {
        driver.findElement(By.id("password")).sendKeys(pwd);
    }

    public void clickLoginBtn() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
