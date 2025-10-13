package com.webautomation.Page_Factory.Object_Repository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationObjectRepository {

    @FindBy(id = "first-name")
    public WebElement FirstName;

    @FindBy(id = "last-name")
    public WebElement LastName;
    
    @FindBy(id = "postal-code")
    public WebElement PostalCode;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement ContinueButton;

    public InformationObjectRepository(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
