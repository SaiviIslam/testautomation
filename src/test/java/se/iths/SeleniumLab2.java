package se.iths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SeleniumLab2 {

    WebDriver myBrowser;

    @Before
    public void setMyBrowser() {
        myBrowser = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        //myBrowser.quit();
    }

    @Test
    public void seleniumLab2() {


        myBrowser.get("https://www.seleniumhq.org");
        WebElement download = myBrowser.findElement(By.xpath("//*[@id=\"menu_download\"]/a"));
        download.click();

        List<WebElement> link1 = myBrowser.findElements(By.cssSelector("#mainContent > table:nth-child(29) > tbody > tr > td:nth-child(1) > a"));
        List<String> urls = new ArrayList<>();

        for (int i = 0; i < link1.size(); i++) {
            String url = link1.get(i).getAttribute("href");
            urls.add(url);
        }
        for (String u: urls) {
            myBrowser.get(u);
        }

    }

}
