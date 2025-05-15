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

}
