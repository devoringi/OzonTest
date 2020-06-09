package ruOzon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogTest extends WebDriverSettings{
    @Test
    public void Log () {

        driver.get("https://www.ozon.ru");
       // driver.findElement(By.xpath("//div[@class ='a0b5 b0f6 a9s']")).click();
        driver.findElement(By.xpath("//*[contains(text(), \"Войти\")]/parent::div")).click();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), \"Кабинет\")]")).isEnabled());

    }

}