package com.webautomation.Page_Factory.Page;

import org.openqa.selenium.WebDriver;

import com.webautomation.AbstractComponents.AbstractComponents;
import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;

public class LoginPage extends AbstractComponents{

    private LoginObjectRepository loginObjectRepository;
    

    public LoginPage(WebDriver driver) {
        super(driver);
        this.loginObjectRepository = new LoginObjectRepository(driver);
    }

    public void DoLogin(String username, String password){
        waitForVisibilityElement(loginObjectRepository.UserName2);
        waitForVisibilityElement(loginObjectRepository.Password2);
        loginObjectRepository.UserName.sendKeys(username);
        loginObjectRepository.Password.sendKeys(password);
    }

    public void ButtonLogin(){
        loginObjectRepository.LoginButton.click();
    }

}
