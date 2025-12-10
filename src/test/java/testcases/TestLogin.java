package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProductPage;
import utilities.Dataset;
import utilities.DriverSetUp;

public class TestLogin extends DriverSetUp {
    LogInPage logInPage = new LogInPage();
    ProductPage productPage = new ProductPage();


    @Test
    public void testLogInWithValidCredentials(){
        getBrowser().get(logInPage.loginPageURL);
        logInPage.writeOnElement(logInPage.usernameBox, "standard_user");
        logInPage.writeOnElement(logInPage.passwordInputBox, "secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        Assert.assertEquals(getBrowser().getCurrentUrl(), productPage.productPageURL);


    }

    @Test
    public void testLogInWithInValidPassword(){
        getBrowser().get(logInPage.loginPageURL);
        logInPage.writeOnElement(logInPage.usernameBox, "standard_user");
        logInPage.writeOnElement(logInPage.passwordInputBox, "sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        System.out.println(logInPage.errorMsg);
        Assert.assertTrue(logInPage.getElement(logInPage.errorMsg).isDisplayed());
        Assert.assertEquals(logInPage.getElementText(logInPage.errorMsg),"Epic sadface: Username and password do not match any user in this service");


    }


    @Test
    public void testLogInWithInValidUsername(){
        getBrowser().get(logInPage.loginPageURL);
        logInPage.writeOnElement(logInPage.usernameBox, "stdard_user");
        logInPage.writeOnElement(logInPage.passwordInputBox, "secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        System.out.println(logInPage.errorMsg);
        Assert.assertTrue(logInPage.getElement(logInPage.errorMsg).isDisplayed());
        Assert.assertEquals(logInPage.getElementText(logInPage.errorMsg),"Epic sadface: Username and password do not match any user in this service");


    }

    @Test
    public void testLogInWithInValidUsernameAndPassword(){
        getBrowser().get(logInPage.loginPageURL);
        logInPage.writeOnElement(logInPage.usernameBox, "stdard_user");
        logInPage.writeOnElement(logInPage.passwordInputBox, "secr_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        System.out.println(logInPage.errorMsg);
        Assert.assertTrue(logInPage.getElement(logInPage.errorMsg).isDisplayed());
        Assert.assertEquals(logInPage.getElementText(logInPage.errorMsg),"Epic sadface: Username and password do not match any user in this service");


    }


    @Test(dataProvider = "invalidData", dataProviderClass = Dataset.class)
    public void testLogInWithInValidCredentials(String username, String password, String errorMsg){
        getBrowser().get(logInPage.loginPageURL);
        logInPage.writeOnElement(logInPage.usernameBox,username);
        logInPage.writeOnElement(logInPage.passwordInputBox,password);
        logInPage.clickOnElement(logInPage.loginButton);
        System.out.println(logInPage.errorMsg);
        Assert.assertTrue(logInPage.getElement(logInPage.errorMsg).isDisplayed());
        Assert.assertEquals(logInPage.getElementText(logInPage.errorMsg),errorMsg);


    }




}
