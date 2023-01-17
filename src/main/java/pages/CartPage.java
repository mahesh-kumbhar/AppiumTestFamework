package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import userActions.UserActions;

import java.time.Duration;

public class CartPage extends UserActions
{
    AppiumDriver driver;
    CartPage(AppiumDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);
    }
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    private WebElement txtMyCart;

    @AndroidFindBy(accessibility = "//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]/android.widget.TextView")
    private WebElement btnProceedToCheckout;

    public void openCheckout()
    {
        waitForElement(txtMyCart);
        click(btnProceedToCheckout,"Button 'Proceed To Checkout");
    }

}
