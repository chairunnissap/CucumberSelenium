package com.webautomation.Page_Factory.Object_Repository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartObjectRepository {
    public By cartLink = By.xpath("//a[@class='shopping_cart_link']");
    public By listProductVerif = By.cssSelector("[data-test='inventory-item']");
    public By Name = By.cssSelector("[data-test='inventory-item-name']");
    public By Price = By.cssSelector("[data-test='inventory-item-price']");
    public By Qty = By.cssSelector("[data-test='item-quantity']");
    public By Continue = By.xpath("//button[@data-test='checkout']");

    public CartObjectRepository(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
