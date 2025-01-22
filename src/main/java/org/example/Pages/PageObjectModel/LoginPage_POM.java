package org.example.Pages.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_POM {

    WebDriver driver;
    public LoginPage_POM(WebDriver driver)
    {
        this.driver=driver;
    }


    // Locators
    private By username= By.id("login-username");
    private By password=By.id("login-password");
    private By signButton=By.id("js-login-btn");
    private By error_msg=By.id("js-notification-box-msg");

    //Actions
    public String LoginToVwoInvalidCreds(String user, String pwd) {

        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();


//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(error_msg));

        String error_msg_text=driver.findElement(error_msg).getText();
        return error_msg_text;
    }


}
