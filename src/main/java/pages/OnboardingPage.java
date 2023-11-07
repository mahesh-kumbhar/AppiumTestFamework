package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import userActions.UserActions;

public class OnboardingPage  extends UserActions
{
    private final AppiumDriver driver;

    public OnboardingPage(AppiumDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy( accessibility= "create account")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement btnCreateAccount;


    @AndroidFindBy( xpath= "//*[@text='Do You Have Tickets?']")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement hdrDoYouHaveTickets;

    @AndroidFindBy( xpath= "//android.widget.Button[@content-desc=\"yes\"]")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement btnYes;

    @AndroidFindBy( xpath= "//android.widget.Button[@content-desc=\"no\"]")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement btnNo;

    @AndroidFindBy( accessibility= "maybe later")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement maybeLater;

    @AndroidFindBy( accessibility= "not right now")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement notRightNow;

    @AndroidFindBy( accessibility= "continue")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement btnContinue;

    @AndroidFindBy( id= "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement whileUsingTheApp;

    @AndroidFindBy( id= "com.android.permissioncontroller:id/permission_allow_button")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement optionAllow;

    @AndroidFindBy( id= "com.android.permissioncontroller:id/permission_deny_button")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement optionDontAllow;

    @AndroidFindBy( accessibility= "done")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement btnDone;

    @AndroidFindBy( xpath= "//*[@text='YES']")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement reminderYes;

    @AndroidFindBy( xpath= "//*[@text='NO']")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement reminderNo;

    @AndroidFindBy( id= "com.universalstudios.orlandoresort:id/toolbar_with_logo_image")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement logoUO;

    //******************************  Functions *********************************************
    public void skipTickets()
    {
        click(btnNo,"Button 'No' for 'Do You Have Tickets' for SCAN TICKETS");
    }

    public void maybeLaterForTickets()
    {
        click(maybeLater,"Selected option 'MAYBE LATER' for 'Purchase Tickets In The App'");
    }

    public void skipPINSetup()
    {
        click(notRightNow,"Selected option 'NOT RIGHT NOW' for 'PIN Setup' for TapuTapu wearable");
    }

    public void enableLocation(boolean locationState)
    {
        click(btnContinue, "Button 'CONTINUE' for Turn On Location");
        if(locationState)
            click(whileUsingTheApp, "Option 'While Using App' for Location");
        else
            click(optionDontAllow, "Option 'Don't allow' for Location");

    }

    public void enableNotifications(boolean notificationState)
    {
        click(btnContinue, "Button 'CONTINUE' for Turn On Notification");
        if(notificationState)
            click(optionAllow, "Option 'Allow' for Notification");
        else
            click(whileUsingTheApp, "Option 'Deny' for Notification");
    }

    public void completeAccountSetup(boolean reminder)
    {
        click(btnDone,"Button 'Done' for Complete Account Setup");
        if(reminder)
            click(reminderYes,"option 'YES' for Complete Account Setup reminder");
        else
            click(reminderNo,"option 'NO' for Complete Account Setup reminder");
    }

    public void enableNearbyDevices(boolean permission)
    {
        addLog("Allow Universal FL to find, connect to, and determine the relative position of nearby devices?");
        if(permission)
            click(optionAllow,"option 'ALLOW' for nearby devices Access");
        else
            click(optionDontAllow,"option 'Don't Allow' for nearby devices Access");

        waitForElement(logoUO);
        addLog("Onboarding completed successfully. Home Page verified successfully.");
    }
}
