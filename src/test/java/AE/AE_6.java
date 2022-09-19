package AE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AE_6 {

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
        Thread.sleep(5000);
         driver.close();
    }

    @Test
    public void test1() {

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed());

        //4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

        //5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());

        //6. Adı, e-posta adresini, konuyu ve mesajı girin
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Hüseyin");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("has55wee@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa='subject']")).sendKeys("Ürün Fiyatları Hakkında");
        driver.findElement(By.xpath("//*[@id='message']")).sendKeys("Hangi ürüne baksam ATEŞ pahası!");

        //7. Dosya yükle
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name='upload_file']")).isDisplayed());

        //8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='submit-button']")).click();

        //9. Tamam düğmesine tıklayın
        driver.switchTo().alert().accept(); // JS MENÜ OK

        //10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='status alert alert-success']")).isDisplayed());

        // 11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        driver.findElement(By.xpath("(//*[@href='/'])[2]")).click(); // ANA SAYFAYA DÖN tıkla
        Assert.assertTrue(driver.findElement(By.xpath("(//title)[1]")).isDisplayed());




    }



}
