package com.webautomation.Page_Factory.Object_Repository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardObjectRepository {

    public By AddProductToCart = By.cssSelector("button.btn_inventory");
    public By listProduct = By.cssSelector("div.inventory_item");
    public By Name = By.cssSelector(".inventory_item_name");
    public By Price = By.cssSelector(".inventory_item_price");

    public DashboardObjectRepository(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

}
