package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetUp {


    private static final ThreadLocal<WebDriver> LOCAL_BROWSER = new ThreadLocal<>();

    public static void setBrowser(WebDriver browser) {
        DriverSetUp.LOCAL_BROWSER.set(browser);
    }

    public static WebDriver getBrowser() {
        return LOCAL_BROWSER.get();
    }



    public static WebDriver getBrowser(String browserName){
        if (browserName.equalsIgnoreCase("Chrome")){
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            return new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            return new FirefoxDriver();
        }else {
            throw new RuntimeException("Browser is not available with the given name: " + browserName);
        }

    }


    public static void openBrowser(String browserName){
        WebDriver browser = getBrowser(browserName);
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setBrowser(browser);

    }


    public static void quitBrowser(){
        getBrowser().quit();
    }
}
