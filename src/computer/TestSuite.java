package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Click on Computer Menu
        clickOnElement(By.linkText("Computers"));
        //1.2 Click on Desktop
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("products-orderby"),"Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order
        //Expected message
        String expectedText = "Name: Z to A";
        //Actual message and get text
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        //verify actual and expected message
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        //2.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));

        //2.2 Click on Desktop
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("products-orderby"),"Name: A to Z");

        //2.4 Click on "Add To Cart"
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //2.5 Verify the Text "Build your own computer"
        // Expected Text
        String expectedText = "Build your own computer";

        //Get actual text
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));

        //Verify actual and expected text
        Assert.assertEquals(expectedText,actualText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropDown(By.id("product_attribute_1"),"1");

        //2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(3000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
       mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_3_7']"));

       //2.9 Select OS radio "Vista Premium [+$60.00]"
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_4_9']"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        mouseHoverToElement(By.xpath("//input[@id='product_attribute_5_10']"));
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_5_12']"));

        //2.11 Verify the price "$1,475.00"
        Thread.sleep(3000);
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals(expectedPrice,actualPrice);

        //2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedMessage,actualMessage);
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify the message "Shopping cart"
        Thread.sleep(3000);
        String expectedMessageCart = "Shopping cart";
        String actualMessageCart = getTextFromElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedMessage,actualMessage);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendTextToElement(By.xpath("//input[@value='1']"),"2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        Thread.sleep(5000);
        String expectedPrice1 = "$2,950.00";
        String actualPrice1 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals(expectedPrice1,actualPrice1);

        //2.18 click on checkbox “I agree with the terms of service”
        mouseHoverToElementAndClick(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(5000);
        String expectedTextWelcome = "Welcome, Please Sign In!";
        String actualTextWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedPrice1,actualPrice1);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Adam");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Smith");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"Adam1@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"),"Alabama");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"Charlie road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA5 3NN");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"1234567890");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.name("save"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card” and click on continue
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(3000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");

        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Adam");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5555555555554444");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"7");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"802");

        //2.29 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
        Thread.sleep(3000);
        String expectedPaymentMethod = "Payment Method: Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals(expectedPaymentMethod,actualPaymentMethod);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Shipping Method: Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Shipping Method is not correct", expectedShippingMethod,actualShippingMethod);

        //2.33 Verify Total is “$2,950.00”
        String expectedFinalTotal = "$2,950.00";
        String actualFinalTotal = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("Final Total is not correct", expectedFinalTotal,actualFinalTotal);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.35 Verify the Text “Thank You”
        String expectedText1="Thank you";
        String actualText1=getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Payment Error",expectedText1,actualText1);

        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedText2 = "Your order has been successfully processed!";
        String actualText2 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Thank You does not display", expectedText2,actualText2);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.38 Verify the text “Welcome to our store”
        Thread.sleep(3000);
        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome to our store not displayed", expectedWelcome,actualWelcome);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
