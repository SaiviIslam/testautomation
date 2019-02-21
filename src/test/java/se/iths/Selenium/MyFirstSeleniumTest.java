package se.iths.Selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyFirstSeleniumTest {
    WebDriver myBrowser;

    @Before
    public void setUpBrowser(){
        myBrowser = new ChromeDriver();
    }

    @After
    public void closeBrowser(){
       // myBrowser.quit();
    }

    @Test
    public void myVeryFirstTest()
    {

        GettingTheWebsite s = new GettingTheWebsite(myBrowser);

        s.Gettingurl();

        s.gettingTheDressIntoCart();

        s.proceedToTheCheckout();

        s.signIn();


        s.address();

        s.shipping();

        s.payment();

        s.placeOrder();

        myBrowser.manage().window().maximize();






       // WebElement inputField = myBrowser.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
      //  inputField.sendKeys("apa");
       // inputField.submit();
       // WebElement firstSearchResult = myBrowser.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/a/h3"));


       // Assert.assertEquals(
      //          "American Psychological Association (APA)",
      //          firstSearchResult.getText()
      //  );

    }
}
