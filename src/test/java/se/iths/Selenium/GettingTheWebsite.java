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

public class GettingTheWebsite {

    WebDriver driver;


public GettingTheWebsite (WebDriver driver ){
    this.driver= driver;

        }
        public void Gettingurl(){
            driver.get("http://automationpractice.com");
            driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("Printed Chiffon Dress");
            driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).submit();
        }

        public void gettingTheDressIntoCart(){
            WebElement clickForAddTOCart =  driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
            clickForAddTOCart.click();

        }

        public void proceedToTheCheckout(){
            WebElement clickForProceedToCheckout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
            ExpectedCondition proceedToCheckoutIsClickable = ExpectedConditions.elementToBeClickable(clickForProceedToCheckout);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(proceedToCheckoutIsClickable);
            clickForProceedToCheckout.click();
        }

        public void signIn(){

            driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("o12728093@nwytg.net");
            driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Saivi332");
            driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        }

        public void address(){
            driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
            driver.findElement(By.xpath("//*[@id=\"form\"]/div/p[2]/label")).click();
        }

        public void shipping(){
            driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        }
        public void payment(){
            driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        }

        public void placeOrder(){
            driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).submit();
        }

}
