package org.example.VwoTests;

import org.checkerframework.checker.units.qual.C;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.PageObjectModel.Login_POM;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.logging.Logger;


public class vwoTest_pom extends CommonToAllTest {


    private static final Logger logger = LogManager.getLogger(vwoTest_pom.class);



    @Test
    public  void realTest(){

        Login_POM loginPom = new Login_POM(DriverManager.getDriver());
        String err = loginPom.loginWithInvalidCred(PropertyReader.readKey("invalid_username"),PropertyReader.readKey("invalid_password"));
        Assert.assertEquals(err, PropertyReader.readKey("error_message"));

    }


}
