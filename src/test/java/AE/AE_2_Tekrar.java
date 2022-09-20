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

public class AE_2_Tekrar {


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
    public void test() throws InterruptedException {

        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        // 3. Verify that home page is visible successfully
        String webTitle = driver.getTitle();
        String arananWebTitle = "Automation Exercise";
        Assert.assertTrue(webTitle.contains(arananWebTitle));

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // 5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        //5. Verify 'Login to your account' is visible
        WebElement webLoginYazisi = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(webLoginYazisi.isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        //6. Enter correct email address and password
        WebElement LoginEMailKutusu = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
        LoginEMailKutusu.sendKeys("huseyin123456789@gmail.com");
        Thread.sleep(1000);
        WebElement LoginPassword = driver.findElement(By.xpath("//*[@name='password']"));
        LoginPassword.sendKeys("123456789");
        Thread.sleep(1000);

        // 7. 'Giriş' düğmesini tıklayın
        //7. Click 'login' button
        WebElement LoginButonu = driver.findElement(By.xpath("(//*[@type='submit'])[1]"));
        Thread.sleep(1000);
        LoginButonu.click();


        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        //8. Verify that 'Logged in as username' is visible
        WebElement LoggedInAssYazisi = driver.findElement(By.xpath(" //*[@class='fa fa-user']"));
        Assert.assertTrue(LoggedInAssYazisi.isDisplayed());


        //9. 'Hesabı Sil' düğmesini tıklayın
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath(" //*[text()=' Delete Account']")).click();

        //10. 'HESAP SİLİNDİ!' görünür
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement webDeleteAccountYazisi=driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(webDeleteAccountYazisi.isDisplayed());
    }

    @AfterClass
    public static void tearDown() {

        // driver.close();
    }

}

