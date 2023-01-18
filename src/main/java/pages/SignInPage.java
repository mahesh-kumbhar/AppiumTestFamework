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

    @AndroidFindBy( xpath= "//android.widget.TextView[@text='Sign in with Email']")
    @iOSXCUITFindBy( iOSClassChain= "**/XCUIElementTypeButton[`label == \"Sign in with Email\"`]")
    private WebElement btnSignInViaEmail;
    @AndroidFindBy(xpath ="(//android.widget.EditText[@content-desc=\"Input\"])[1]")
    @iOSXCUITFindBy(iOSNsPredicate ="name == \"Input\" AND type == \"XCUIElementTypeTextField\"")
    private WebElement usernameInput;

    @AndroidFindBy( xpath= "(//android.widget.EditText[@content-desc=\"Input\"])[2]")
    @iOSXCUITFindBy( iOSNsPredicate= "name == \"Input\" AND type == \"XCUIElementTypeSecureTextField\"")
    private WebElement passwordInput;

    @AndroidFindBy( xpath= "//android.widget.TextView[@text=\"Sign in\"]")
    @iOSXCUITFindBy( iOSNsPredicate= "label == \"Sign in\" AND name == \"Button_primary\"")
    private WebElement btnSignIn;

    @AndroidFindBy( xpath= "//android.widget.TextView[@text=\"Sign in\"]")
    @iOSXCUITFindBy( xpath= "Home")
    private WebElement tabHome;

    public void enterUsername(String username) {
        sendKeys(usernameInput,"User Name",username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput,"Password",password);
    }

    public void openSignInViaEmail() {
        longWaitForElement(btnSignInViaEmail);
        click(btnSignInViaEmail,"Button 'Sign In Via Email'");
    }

    public void clickSignInButton() {
        click(btnSignIn,"Button 'Sign in'");
    }

    public HomePage verifyLoginSuccess()
    {
        waitForElement(tabHome);
        return new HomePage(driver);
    }




}
