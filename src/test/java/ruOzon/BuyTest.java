package ruOzon;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class BuyTest extends WebDriverSettings{
    @Test
    public void Buy(){
        driver.get("https://www.ozon.ru");
        driver.findElement(By.xpath("//button[@class = 'ui-a9']")).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@href = '/category/bytovaya-tehnika-10500/']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@href = '/category/tehnika-dlya-kuhni-10523/']")).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@href = '/category/sokovyzhimalki-10592/']")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@qa-id ='range-from']")).sendKeys("\b\b\b\b\b\b");
        driver.findElement(By.xpath("//input[@qa-id ='range-from']")).sendKeys("3000");
        driver.findElement(By.xpath("//input[@qa-id ='range-from']")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@qa-id ='range-to']")).sendKeys("\b\b\b\b\b\b\b");
        driver.findElement(By.xpath("//input[@qa-id ='range-to']")).sendKeys("4000");
        driver.findElement(By.xpath("//input[@qa-id ='range-to']")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String expectedRez = "Цена: от 3 000 до 4 000";
        String actualRez = driver.findElement(By.xpath("//span[contains(text(),\"Цена\")]")).getText();
        Assert.assertTrue(actualRez.equals(expectedRez));
        driver.findElement(By.xpath("//input[@class = 'ui-a1f3']")).click();
        driver.findElement(By.xpath("//*[contains(text(), \"В корзину\")]/parent::div")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0; i<4; i++) {
            driver.findElement(By.xpath("//span[contains(text(), \"шт\")]/following-sibling::div")).click();
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String countExpect = driver.findElement(By.xpath("//span[contains(text(), \" шт\")]")).getText();
        for (int i=0; i<3; i++) {
            countExpect = countExpect.substring(0, countExpect.length() - 1);
        }
        driver.findElement(By.xpath("//a[@href = '/cart']")).click();
        int countEx = Integer.parseInt(countExpect);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualCount = driver.findElement(By.cssSelector("div.ui-a1k9")).getText();
        int count = Integer.parseInt(actualCount);
        Assert.assertTrue(count == countEx);
    }
}
