package step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LogInPage;
import pages.ProductPage;

import static utilities.DriverSetUp.getBrowser;

public class LoginStep {

    LogInPage logInPage = new LogInPage();
    ProductPage productPage = new ProductPage();


    @Given("User should be on the login page")
    public void userShouldBeOnTheLoginPage() {
        getBrowser().get(logInPage.loginPageURL);

    }

    @And("User enter username on the username field")
    public void userEnterUsernameOnTheUsernameField() {
        logInPage.writeOnElement(logInPage.usernameBox, "standard_user");
    }

    @And("User enter password on the password field")
    public void userEnterPasswordOnThePasswordField() {
        logInPage.writeOnElement(logInPage.passwordInputBox, "secret_sauce");
    }

    @When("User click on the login button")
    public void userClickOnTheLoginButton() {
        logInPage.clickOnElement(logInPage.loginButton);
    }

    @Then("User should navigate to product page")
    public void userShouldNavigateToProductPage() {
        Assert.assertEquals(getBrowser().getCurrentUrl(), productPage.productPageURL);
    }
}
