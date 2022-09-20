package Day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_Odev {
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
Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

       // 1)http://demo.guru99.com/test/guru99home/sitesinegidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");


       // 2)sayfadaki iframe sayısınıbulunuz.
       // 3)ilk iframe’deki (Youtube) play butonunatıklayınız.
       // 4)ilk iframe’den çıkıp ana sayfayadönünüz
       // 5)ikinci iframe’deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html) tıklayınız
    }
}
