package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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

    @AndroidFindBy(xpath ="(//android.widget.EditText[@content-desc=\"Input\"])[1]")
    private WebElement usernameInput;

    @AndroidFindBy( xpath= "(//android.widget.EditText[@content-desc=\"Input\"])[2]")
    private WebElement passwordInput;

    @AndroidFindBy( xpath= "//android.widget.TextView[@text='Sign in with Email']")
    private WebElement btnSignInViaEmail;

    @AndroidFindBy( xpath= "//android.widget.TextView[@text=\"Sign in\"]")
    private WebElement btnSignIn;
    public void enterUsername(String username) {
        sendKeys(usernameInput,"User Name",username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput,"Password",password);
    }

    public void openSignInViaEmail() {
        click(btnSignInViaEmail,"Button 'Sign In Via Email'");
    }

    public void clickSignInButton() {
        click(btnSignIn,"Button 'Sign in'");
    }



}
