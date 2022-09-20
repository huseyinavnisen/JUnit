package Day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandles {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        //Thread.sleep(5000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        // pencereyi kendi açtığı için List kullanacağız
        List<String> windowHandleList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleList.get(1));

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowHandleList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }
}
