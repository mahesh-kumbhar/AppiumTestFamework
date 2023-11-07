package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import userActions.UserActions;

import java.time.Duration;

public class CreateAccountPage extends UserActions
{
    private final AppiumDriver driver;

    public CreateAccountPage(AppiumDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy( accessibility= "sign in")
    @iOSXCUITFindBy( iOSClassChain= "XXX")
    private WebElement btnSignIn;

    public SignInPage openSignInViaEmail() {
        longWaitForElement(btnSignIn);
        click(btnSignIn,"Button 'SIGN IN'");
        return new SignInPage(driver);
    }


}
