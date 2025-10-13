package com.webautomation.Page_Factory.Object_Repository;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewObjectRepository {
    @FindBy(css = "[data-test='inventory-item']")
    public List<WebElement> listProductOverview;

    public By Price = By.cssSelector("[data-test='inventory-item-price']");
    public By PriceTotal = By.cssSelector("[data-test='subtotal-label']");
    public By Finish = By.xpath("//button[@id='finish']");

    public OverviewObjectRepository(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
