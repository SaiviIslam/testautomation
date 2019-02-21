package se.iths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankTest {

    WebDriver myBrowser;

    @Before
    public void setUpBrowser() {
        myBrowser = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        // myBrowser.quit();
    }

    @Test
    public void BankTest() {

        myBrowser.get("http://www.way2automation.com/angularjs-protractor/banking");

        WebElement loginAsManagerButton = myBrowser.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[2]/button"));
        ExpectedCondition ex = ExpectedConditions.elementToBeClickable(loginAsManagerButton);
        WebDriverWait wait = new WebDriverWait(myBrowser,5);
        wait.until(ex);
        loginAsManagerButton.click();
    }
}
