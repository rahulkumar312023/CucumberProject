package pages;

import org.openqa.selenium.By;

public class LogInPage extends BasePage{

    public String loginPageURL = "https://www.saucedemo.com/v1/index.html";

    public String loginPageTitle = "Swag Labs";

    public By usernameBox = By.xpath("//input[@id='user-name']");

    public By passwordInputBox = By.xpath("//input[@id='password']");

    public By errorMsg = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");

    public By loginButton = By.xpath("//input[@id='login-button']");

    public void doLogin(String email, String password){
        loadAWebpage(loginPageURL);
        writeOnElement(usernameBox, email);
        writeOnElement(passwordInputBox, password);
        clickOnElement(loginButton);

    }
}
