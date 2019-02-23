package se.iths.Selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumTest {
    WebDriver driver;

    @Before
    public void setUpBrowser(){
        driver = new ChromeDriver();
    }

    @After
    public void closeBrowser(){
       // myBrowser.quit();
    }

    @Test
    public void myVeryFirstTest()
    {
        MyFirstSeleniumLab s = new MyFirstSeleniumLab(driver);
        s.BuyingAShiffonDress();
        driver.manage().window().maximize();
        WebElement result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1"));

        Assert.assertEquals(
                "ORDER CONFIRMATION",
                result.getText()
        );

    }
}
