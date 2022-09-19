package AE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AE_5 {
    // BU ÖRNEKTE DAHA ÖNCE KAYIT EDİLMİŞ İSİM ve MAİL TEKRAR
    // GİRİLMEYE ÇALIŞILDIĞINDA HATA VERİLDİĞİNİN KONTROLÜ YAPILIYOR
    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        //Thread.sleep(5000);
       driver.close();
    }

    @Test
    public void test1() {

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());

        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("huseyin");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("has55wee@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: red;']")).isDisplayed());
    }


}
