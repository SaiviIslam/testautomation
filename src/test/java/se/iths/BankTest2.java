package se.iths;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BankTest2 {
    @Test

    public void addCustomer() {
        By loginManagerButton = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[2]/button");
        By addNewCustomerButton = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[1]");

        open("http://www.way2automation.com/angularjs-protractor/banking");

        $("body > div.ng-scope > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button").click();
        $("body > div.ng-scope > div > div.ng-scope > div > div.center > button:nth-child(1)").click();
        $("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(1) > input").sendKeys("Saivi");
        //$("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(1) > input").submit();
        $("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(2) > input").sendKeys("Islam");
        //$("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(2) > input").submit();
        screenshot("apa");
    }
}
