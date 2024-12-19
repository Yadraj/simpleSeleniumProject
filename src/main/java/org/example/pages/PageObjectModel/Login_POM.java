package org.example.pages.PageObjectModel;

import org.example.base.CommonToAllPage;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_POM extends CommonToAllPage {

    WebDriver driver;
    public Login_POM(WebDriver driver){
        this.driver=driver;

    }

    private By userName = By.id("login-username");
    private By passWord = By.name("password");
    private By submitButton = By.id("js-login-btn");
    private By errorMessage = By.className("notification-box-description");



    public String loginWithInvalidCred(String usename,String pass){

        driver.get(PropertyReader.readKey("url"));
        driver.findElement(userName).sendKeys(usename);
        driver.findElement(passWord).sendKeys(pass);
        driver.findElement(submitButton).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement error_msg = driver.findElement(errorMessage);
        String error_msg_text = error_msg.getText();
//        String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
//        System.out.println(error_msg_attribute_dataqa);
        return error_msg_text;

    }




}
