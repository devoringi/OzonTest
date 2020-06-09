package ruOzon;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
    public ChromeDriver driver;
    @Before
    public  void setUp (){
        // driver.get("https://www.ozon.ru");
        System.setProperty("webdriver.chrome.driver", "/webdrivers/chromedriver1.exe");
        driver = new ChromeDriver();
    }
    @After
    public void close(){
        driver.quit();
    }
}