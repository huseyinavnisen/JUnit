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

public class AE_4 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }


    @Test
    public void test1() throws InterruptedException {


        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-home']")).isDisplayed());

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // 5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());

        // 6. Enter correct email address and password
        driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys("has55wee@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("12345678");
        Thread.sleep(3000);

        // 7. Click 'login' button
        driver.findElement(By.xpath("//*[text()='Login']")).click();

        // 8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        // 9. Click 'Logout' button
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();

        // 10. Verify that user is navigated to login page
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}

