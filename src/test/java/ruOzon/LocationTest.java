package ruOzon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;


public class LocationTest extends WebDriverSettings{
    @Test
    public void Locate () {

        driver.get("https://www.ozon.ru");
        driver.findElement(By.xpath("//*[contains(text(), \"Энгельс\")]/parent::button")).click();
        driver.findElement(By.xpath("//input[@class = 'ui-av9 ui-av6']")).sendKeys("Вольск");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@class = 'a3']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), \"Вольск\")]")).isEnabled());
    }

}