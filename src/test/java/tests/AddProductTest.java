package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductDetailsPage;

public class AddProductTest extends BaseSettings
{
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;

    @Test
    public void AddToCartAndOpenCart()
    {
       // productDetailsPage= homePage.openFirstProductPdpPage();
        productDetailsPage.AddToCart();
        cartPage= productDetailsPage.openCart();
    }

    @Test
    public void VerifyInCart()
    {
       // cartPage.openCheckout();
    }

}
