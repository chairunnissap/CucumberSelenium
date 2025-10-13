package com.webautomation.Page_Factory.Page;
import org.openqa.selenium.WebDriver;
import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;

public class LoginPage {

    private LoginObjectRepository loginObjectRepository;

    public LoginPage(WebDriver driver) {
        this.loginObjectRepository = new LoginObjectRepository(driver);
    }

    public void DoLogin(String username, String password){
        loginObjectRepository.UserName.sendKeys(username);
        loginObjectRepository.Password.sendKeys(password);
    }

    public void ButtonLogin(){
        loginObjectRepository.LoginButton.click();
    }
}
