package Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClass_AfterClass {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static  void tearDown(){
        driver.close();
    }

    @Test
    public void method1() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.amazon.com");
    }

    @Test
    @Ignore // Bu kısım Çalışmaz
    public void method2() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://techproeducation.com");
    }

    @Test
    public void method3() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://hepsiburada.com");
    }

}
