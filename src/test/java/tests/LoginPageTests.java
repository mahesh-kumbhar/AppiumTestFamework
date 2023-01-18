package tests;

import org.testng.annotations.Test;


public class LoginPageTests extends BaseSettings
{

    @Test
    public void login()
    {
        signInPage.openSignInViaEmail();
        signInPage.enterUsername("recipeuser@test.com");
        signInPage.enterPassword("123456");
        signInPage.clickSignInButton();
        signInPage.verifyLoginSuccess();
   }

   // @Test
    public void logout()
    {
        //homePage.logout();
    }


}
