package electronics;

import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully()throws InterruptedException{
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //1.3 Verify the text “Cell phones”
        Thread.sleep(3000);
        verifyMessage("Cell phones",getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")));

    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException{
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //2.3 Verify the text “Cell phones”
        verifyMessage("Cell phones",getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")));

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //Verify the text “Nokia Lumia 1020”
        verifyMessage("Nokia Lumia 1020",getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]")));

        //Verify the price “$349.00”
        verifyMessage("$349.00",getTextFromElement(By.xpath("//span[@id='price-value-20']")));

        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button.
        verifyMessage("The product has been added to your shopping cart",getTextFromElement(By.xpath("//p[@class='content']")));
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        verifyMessage("Shopping cart",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));

        //2.13 Verify the quantity is 2
        verifyMessage("(2)",getTextFromElement(By.xpath("//span[contains(text(),'(2)')]")));

        //2.14 Verify the Total $698.00
        verifyMessage("$698.00",getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")));

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyMessage("Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        verifyMessage("Register",getTextFromElement(By.xpath("//h1[contains(text(),'Register')]")));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Dev");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Coldo");
        sendTextToElement(By.xpath("//input[@id='Email']"),"dev5@gmail.com");//give new email before you run the programme
        sendTextToElement(By.xpath("//input[@id='Password']"),"S12345");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"S12345");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        verifyMessage("Your registration completed",getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")));

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping cart”
        verifyMessage("Shopping cart",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill the Mandatory fields
        Thread.sleep(3000);
       selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
       selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"Alaska");
       sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Austin");
       sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"8,Ruskining road");
       sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HHA 145");
       sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"1234567890");

       //2.28 Click on “CONTINUE”
        clickOnElement(By.name("save"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //2.31 Select Radio Button “Credit Card” & continue
        clickOnElement(By.xpath("//label[contains(text(),'Credit Card')]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"),"visa");

        //2.33 Fill all the details
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Adam");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"4485821584127596");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"7");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"123");

        //2.34 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //Verify “Payment Method” is “Credit Card”
        Thread.sleep(3000);
        verifyMessage("Payment Method: Credit Card",getTextFromElement(By.xpath("//li[@class='payment-method']")));

       //2.36 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(3000);
        verifyMessage("Shipping Method: 2nd Day Air",getTextFromElement(By.xpath("//li[@class='shipping-method']")));

        //2.37 Verify Total is “$698.00”
        Thread.sleep(3000);
        verifyMessage("$698.00",getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")));

        //2.38 Click on “CONFIRM”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        Thread.sleep(3000);
        verifyMessage("Thank you",getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));

        //2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(3000);
        verifyMessage("Your order has been successfully processed!",getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));

       //2.41 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        Thread.sleep(3000);
        verifyMessage("Welcome to our store",getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        verifyMessage("https://demo.nopcommerce.com/",driver.getCurrentUrl());

    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
