package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{
    public String productPageURL = "https://www.saucedemo.com/inventory.html";
    public By productSelection = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public By addToCart = By.xpath("//span[@class='shopping_cart_badge']");
    public By continueShopping = By.xpath("//button[@id='continue-shopping']");
    public By openMenu= By.xpath("//button[@id='react-burger-menu-btn']");
    public By logOut= By.xpath("//a[@id='logout_sidebar_link']");
}
