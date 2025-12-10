package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utilities.DriverSetUp.getBrowser;

public class BasePage {
    public WebElement getElement(By locator){

        return getBrowser().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public void hoverOnElement(By locator){
        Actions actions = new Actions(getBrowser());
        actions.clickAndHold(getElement(locator)).build().perform();
    }

    public void loadAWebpage(String url){
        getBrowser().get(url);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }
}
