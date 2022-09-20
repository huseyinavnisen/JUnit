package Day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_YouTube_Deneme {

    WebDriver driver;
    Select select;


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
        driver.get("https://www.youtube.com/watch?v=2y02QxtTebg");
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']")).click();
        Thread.sleep(4000);
        driver.get("https://www.youtube.com/watch?v=OnbSs7c6hEU");
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button']")).click();
        Thread.sleep(5000);

    }

}
