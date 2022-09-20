package AutomationExerciseQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2_LoginUserWithCorrectEmailAndPassword {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Delete Account' button
    10. Verify that 'ACCOUNT DELETED!' is visible
     */
    WebDriver driver;
    @Before
    public void setUp(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("Msc07@formula1.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("123456789");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
    }
}
