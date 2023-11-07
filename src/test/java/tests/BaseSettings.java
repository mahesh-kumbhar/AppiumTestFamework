package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.CreateAccountPage;
import pages.OnboardingPage;
import pages.SignInPage;

import java.io.IOException;
import java.net.URL;

public class BaseSettings
{
    public static AppiumDriver driver;

    CreateAccountPage createAccountPage;

    @Parameters({"platform"}) //-
    @BeforeClass
    public void setUp(String platform) throws IOException {

        // Start Driver As per capability
        startDriver(platform);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //signInPage = new SignInPage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    public void startDriver(String platform) throws IOException
    {

        // Set the appropriate capabilities for iOS
        if (platform.equalsIgnoreCase("ios")) {
            /*
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
            capabilities.setCapability("appium:udid", "00008030-000C74D10145802E");
            capabilities.setCapability(MobileCapabilityType.APP, "/Users/capgemini/Desktop/BuildReact/FreshDirectReact.ipa");
            capabilities.setCapability("ios:recordScreen", true);

            driver = new IOSDriver(new URL("http://0.0.0.0:4723"), capabilities);
            */
        }
        // Set the appropriate capabilities for Android
        else if (platform.equalsIgnoreCase("android"))
        {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("RZCR403Y7CV");
            //options.setAppPackage("com.universalstudios.orlandoresort"); // Replace with the actual package name of the pre-installed app
            //options.setAppActivity("com.universalstudios.orlandoresort.controller.userinterface.launcher.MainActivity"); // MainActivity Replace with the actual main activity name of the pre-installed app
            //options.setCapability("noReset", "true"); // This prevents Appium from reinstalling the app





            options.setApp("/Users/nbcu/Downloads/Builds/UO/57/57-uatEnv-1570002-Nov2.apk");


            driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);

        }
    }




}
