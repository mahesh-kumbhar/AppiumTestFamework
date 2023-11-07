package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import userActions.UserActions;

import java.time.Duration;

public class SignInPage extends UserActions
{
    private final AppiumDriver driver;

    public SignInPage(AppiumDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    //**************************************** Page Elements
    @AndroidFindBy( xpath= "//android.widget.TextView[@text='Sign in with Email']")
    @iOSXCUITFindBy( iOSClassChain= "**/XCUIElementTypeButton[`label == \"Sign in with Email\"`]")
    private WebElement btnSignInViaEmail;
    @AndroidFindBy(id ="com.universalstudios.orlandoresort:id/etEmail")
    @iOSXCUITFindBy(iOSNsPredicate ="name == \"Input\" AND type == \"XCUIElementTypeTextField\"")
    private WebElement usernameInput;

    @AndroidFindBy( id= "com.universalstudios.orlandoresort:id/etPassword")
    @iOSXCUITFindBy( iOSNsPredicate= "name == \"Input\" AND type == \"XCUIElementTypeSecureTextField\"")
    private WebElement passwordInput;

    @AndroidFindBy( id= "com.universalstudios.orlandoresort:id/btnSignIn")
    @iOSXCUITFindBy( iOSNsPredicate= "label == \"Sign in\" AND name == \"Button_primary\"")
    private WebElement btnSignIn;

    @AndroidFindBy( id= "com.universalstudios.orlandoresort:id/etPassword")
    @iOSXCUITFindBy( xpath= "Home")
    private WebElement tabHome;

    @AndroidFindBy( id= "com.universalstudios.orlandoresort:id/cbRememberMe")
    @iOSXCUITFindBy( xpath= "XXX")
    private WebElement chbxRememberMe;

    @AndroidFindBy( xpath= "//*[@text='Do You Have Tickets?']")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement hdrDoYouHaveTickets;

    //************************************************ Functions ***********************************************

    public void enterUsername(String username) {
        sendKeys(usernameInput,"User Name",username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput,"Password",password);
    }

    public void clickSignInButton() {
        click(btnSignIn,"Button 'Sign in'");
    }

    public OnboardingPage verifyLoginSuccess()
    {
        waitForElement(hdrDoYouHaveTickets);
        return new OnboardingPage(driver);
    }

    public void setRememberMeCheckbox()
    {
        click(chbxRememberMe,"Checkbox Remember Me");
    }
}
