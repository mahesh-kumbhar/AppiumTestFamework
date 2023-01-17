package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import userActions.UserActions;

import java.time.Duration;

public class HomePage extends UserActions
{

    AppiumDriver driver;

    public HomePage(AppiumDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);
    }
    @AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")
    private WebElement burgerMenu;

    @AndroidFindBy(accessibility ="menu item log in")
    private WebElement menuLogin;

    @AndroidFindBy(accessibility ="menu item log out")
    private WebElement menuLogout;

    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Are you sure you sure you want to logout?']")
    private WebElement txtSureWant;

    @AndroidFindBy(id ="android:id/button1")
    private WebElement btnConfirmLogout;

    @AndroidFindBy(xpath ="//android.widget.TextView[@text='You are successfully logged out.']")
    private WebElement txtSuccessMessage;

    @AndroidFindBy(xpath ="//android.widget.Button[@text='OK']")
    private WebElement btnOK;

    @AndroidFindBy(xpath ="(//android.widget.TextView[@content-desc='store item text'])[1]")
    private WebElement firstProduct;

    public SignInPage openLoginTab()
    {
        openBurgerMenu();
        click(menuLogin,"Menu Login");
        return new SignInPage(driver);
    }
    public void openBurgerMenu()
    {
        click(burgerMenu,"Burger Menu");
    }

    public void logout()
    {
        openBurgerMenu();
        click(menuLogout,"Menu Logout");

        waitForElement(txtSureWant);
        click(btnConfirmLogout,"Button Confirm Logout");
        waitForElement(txtSuccessMessage);
        click(btnOK,"Button OK");
    }

    public ProductDetailsPage openFirstProductPdpPage()
    {
        click(firstProduct,"First Product");
        return new ProductDetailsPage(driver);
    }
}
