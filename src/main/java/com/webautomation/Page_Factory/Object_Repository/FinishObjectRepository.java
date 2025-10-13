package com.webautomation.Page_Factory.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FinishObjectRepository {

    public By FinishTeks = By.cssSelector("[data-test='complete-header']");
    public By BackToProduct = By.xpath("//button[@id='back-to-products']");

    public FinishObjectRepository(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
