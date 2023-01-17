package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import userActions.UserActions;

import java.time.Duration;

public class ProductDetailsPage extends UserActions
{
    AppiumDriver driver;
    public ProductDetailsPage (AppiumDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);
    }

    @AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView")
    private WebElement btnPlus;

    @AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]")
    private WebElement btnAddToCart;

    @AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")
    private WebElement iconCart;

    public void AddToCart()
    {
        click(btnPlus,"Button Plus");
        click(btnAddToCart,"Button Add To Cart");
    }

    public CartPage openCart()
    {
        click(iconCart,"Icon CART");
        return new CartPage(driver);
    }
}
