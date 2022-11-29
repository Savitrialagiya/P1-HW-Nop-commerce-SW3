package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    //This method will send text to element
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    //This method will get text from element
    public String getTextFromElement(By by){
       return driver.findElement(by).getText();
    }
    //************************************Alert Methods***********************************//
    //This method will Switch to Alert Method
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method is for accepting Alerts
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //This method is for dismiss Alerts
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // This method is for get text from Alerts
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    // This method is for send text to Alerts
    public void sendTextAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    //************select class method**************************
    // This method will select option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    // This method will select the option by value
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);//Object
        select.selectByValue(text);
    }

    // This method will select the option by index(change int)
    public void selectByIndexFromDropDown(By by, int indexNumber) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);//Object
        select.selectByIndex(indexNumber);
    }
    //****************************Action Class Methods*************************
    //This method will do mouse hover on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(by);
        actions.moveToElement(computer).build().perform();
    }

    //This method will do mouse hover on element and click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement software = driver.findElement(by);
        actions.moveToElement(software).click().build().perform();
    }
    //**********************************Verify Method*********************
    //This method will verify actual and expected message
    public void verifyMessage(String expectedMessage,String actualMessage){
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}




