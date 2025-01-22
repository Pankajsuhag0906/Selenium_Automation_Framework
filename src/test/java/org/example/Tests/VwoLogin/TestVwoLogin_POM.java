package org.example.Tests.VwoLogin;

import org.example.Pages.PageObjectModel.LoginPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVwoLogin_POM {

    @Test
    public void test_Login_Negative(){

        WebDriver driver=new EdgeDriver();
        driver.get("https://app.vwo.com");

        LoginPage_POM loginPagePom=new LoginPage_POM(driver);

        String error_msg=loginPagePom.LoginToVwoInvalidCreds("Pankaj","123");

        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
        driver.quit();
    }
}
