package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUser")
    public WebElement btnLogin; //click
    @FindBy(css = ".closeBtn")
    public WebElement btnFechar; //click
    @FindBy(css = ".PopUp")
    public WebElement divFechaModal; //click
    //@FindBy(name = "username")
    @FindBy(css = "*[name='username']")
    public WebElement inpUserName; //set
    @FindBy(css = "*[name='password']")
    public WebElement inpPassword; //set
    @FindBy(css = "*[name='remember_me']")
    public WebElement inpRemember; //click
    @FindBy(css = "#sign_in_btnundefined")
    public WebElement btnSignIn; //click
    @FindBy(linkText = "CREATE NEW ACCOUNT")
    public WebElement linkCreateAccount; //click
    @FindBy(css = ".loader")
    public WebElement divLoader;

}
