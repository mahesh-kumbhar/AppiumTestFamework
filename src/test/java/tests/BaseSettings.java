package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import pages.SignInPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseSettings
{
    public static AppiumDriver driver;
    SignInPage signInPage ;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        capabilities.setCapability("appium:udid", "00008030-000C74D10145802E");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/capgemini/Desktop/BuildReact/FreshDirectReact.ipa");
        capabilities.setCapability("ios:recordScreen", true);

        driver = new IOSDriver(new URL("http://0.0.0.0:4723"), capabilities);

        /*
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/capgemini/Desktop/BuildReact/FreshDirectReact.apk");
        capabilities.setCapability("android:recordScreen", true);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), capabilities);
*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signInPage = new SignInPage(driver);
    }




}
