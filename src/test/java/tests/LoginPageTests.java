package tests;

import org.testng.annotations.Test;
import pages.HomePage;


public class LoginPageTests extends BaseSettings
{
    HomePage homePage;

    @Test
    public void login()
    {
        signInPage.openSignInViaEmail();
        signInPage.enterUsername("recipeuser@test.com");
        signInPage.enterPassword("123456");
        signInPage.clickSignInButton();
       homePage=signInPage.verifyLoginSuccess();
   }

   // @Test
    public void logout()
    {
        //homePage.logout();
    }


}
