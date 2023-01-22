package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.SignInPage;

import java.io.IOException;
import java.net.URL;

public class BaseSettings
{
    public static AppiumDriver driver;
    SignInPage signInPage ;
    DesiredCapabilities capabilities = new DesiredCapabilities();


    @Parameters({"platform"}) //-
    @BeforeClass
    public void setUp(String platform) throws IOException {

        // Start Driver As per capability
        startDriver(platform);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signInPage = new SignInPage(driver);
    }

    public void startDriver(String platform) throws IOException
    {

        // Set the appropriate capabilities for iOS
        if (platform.equalsIgnoreCase("ios")) {
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
            capabilities.setCapability("appium:udid", "00008030-000C74D10145802E");
            capabilities.setCapability(MobileCapabilityType.APP, "/Users/capgemini/Desktop/BuildReact/FreshDirectReact.ipa");
            capabilities.setCapability("ios:recordScreen", true);

            driver = new IOSDriver(new URL("http://0.0.0.0:4723"), capabilities);

        }
        // Set the appropriate capabilities for Android
        else if (platform.equalsIgnoreCase("android"))
        {
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.APP, "/Users/capgemini/Desktop/BuildReact/FreshDirectReact.apk");
            capabilities.setCapability("android:recordScreen", true);

            driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), capabilities);

        }
    }




}
