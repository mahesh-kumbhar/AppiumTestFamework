package tests;

import org.testng.annotations.Test;
import pages.OnboardingPage;
import pages.SignInPage;


public class SignInPageTests extends BaseSettings
{
   SignInPage signInPage ;
   OnboardingPage onboardingPage;

    @Test
    public void login()
    {
        signInPage =  createAccountPage.openSignInViaEmail();

        // Sign in
        signInPage.enterUsername("UoApp@yopmail.com");
        signInPage.enterPassword("Universal123");
        signInPage.setRememberMeCheckbox();
        signInPage.clickSignInButton();

        // Verify successful login and proceed with onboarding
        onboardingPage = signInPage.verifyLoginSuccess();

        // Onboarding steps
        onboardingPage.skipTickets();
        onboardingPage.maybeLaterForTickets();
        onboardingPage.skipPINSetup();
        onboardingPage.enableLocation(true);
        onboardingPage.enableNotifications(true);
        onboardingPage.completeAccountSetup(false);
        onboardingPage.enableNearbyDevices(true);
   }
}
