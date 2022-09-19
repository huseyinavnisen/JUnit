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

import java.time.Duration;

public class AE_3 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test1() throws InterruptedException {
        // 3. Verify that home page is visible successfully
        String webUrl = driver.getCurrentUrl();
        String gercekUrl = "https://automationexercise.com/";
        Assert.assertTrue(webUrl.equals(gercekUrl));

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        // 5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());

        // 6. Enter incorrect email address and password
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("deneme@deneme.com");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("deneme1234567");
        Thread.sleep(1500);

        // 7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        // 8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed());
        Thread.sleep(3000);
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}
