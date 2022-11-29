package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));
        String expectedMessage = menu;
        //Find the Computer text element and get the text
        String actualMessage = getTextFromElement(By.tagName("h1"));
        //Validate actual and expected message
        Assert.assertEquals("Not navigate to top tab",expectedMessage,actualMessage);
//        List<WebElement> list = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]"));
//        for(WebElement topTab: list){
//            if(topTab.getText().equalsIgnoreCase(menu)){
//                topTab.click();
//                break;
//            }
        }


    @Test
    public void verifyUserCanNavigateToComputerMenu(){
        selectMenu("Computers");
//        clickOnElement(By.linkText("Computers"));
//        String expectedMessage = "Computers";
//        //Find the Computer text element and get the text
//        String actualMessage = getTextFromElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/a"));
//        //Validate actual and expected message
//        Assert.assertEquals("Not navigate to Computer tab",expectedMessage,actualMessage);


        selectMenu("Electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
