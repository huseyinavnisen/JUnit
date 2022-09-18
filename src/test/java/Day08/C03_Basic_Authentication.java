package Day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_Basic_Authentication {
/*

    https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu : https://username:password@URL
    Username    : admin
    password    : admin
    Basarili sekilde sayfaya girildigini dogrulayin
    */
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
       // driver.close();
    }
    @Test
    public void test1(){
       // https://the-internet.herokuapp.com/basic_auth sayfasina gidin
       // asagidaki yontem ve test datalarini kullanarak authentication’i yapin
       // Html komutu : https://username:password@URL
       // Username    : admin
       // password    : admin
       // Basarili sekilde sayfaya girildigini dogrulayin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }

}
