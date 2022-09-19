package AE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class LMS_Giris {


    static WebDriver driver;

    @BeforeClass

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //http://zero.webappsecurity.com/ Adresine gidin
        driver.get("https://lms.techproeducation.com/");

    }

    @AfterClass
    public static void tearDown() {

       // driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //Login butonuna basin
        driver.findElement(By.xpath("//*[text()='Login']")).click();
       // Thread.sleep(1000);

        // GOOGLE giriş kısmına tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-secondary btn-block'])[2]")).click();
        Thread.sleep(5000);

        // havnisen@gmail.com tıklayın
        driver.findElement(By.xpath("//*[text()='havnisen@gmail.com']")).click();
        // Thread.sleep(1000);


        // VIEW'e tıklayın
        driver.findElement(By.xpath("//*[@class='mcc_view']")).click();

        // GO TO ZOOM tıklayın
        driver.findElement(By.xpath("//*[text()='GO TO ZOOM ']")).click();




    }
}

