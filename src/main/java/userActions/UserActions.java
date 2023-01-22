package userActions;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserActions
{
    AppiumDriver driver;

    public UserActions(AppiumDriver driver)
    {
        this.driver=driver;
    }
    public void waitForElement(WebElement element)
    {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void longWaitForElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element,String eleName)
    {
        waitForElement(element);
        element.click();
        addLog("Clicked on : " +eleName);
    }

    public void sendKeys(WebElement element,String eleName,String strVal)
    {
        waitForElement(element);
        element.sendKeys(strVal);
        addLog("Entered : " + eleName + " As : " + strVal);
    }

    public void addLog(String message)
    {
        ReportResources.extentTest.log(Status.INFO, message);

    }


}
