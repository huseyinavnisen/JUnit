package Day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("http://www.amazon.com");

        //2- Url'nin amazon içerdiğini test edelim
        String expectUrl="amazon";
        String actuallUrl=driver.getCurrentUrl();
        Assert.assertTrue(actuallUrl.contains(expectUrl));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        String amazonWindowHandle=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyHandle=driver.getWindowHandle();

        //4- title'in Best Buy içerdiğini test edelim
        String expectedTitle="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        WebElement searcbox=driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys("java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu =  driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime = "java";
        Assert.assertTrue(aramaSonucu.getText().contains(arananKelime));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyHandle);

        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());
        //9- Sayfaları Kapatalım
        driver.quit();

    }
}
