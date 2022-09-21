package Secme_Sorular;

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

public class S02_DropDown {


        // 1. http://zero.webappsecurity.com/ Adresine gidin
        // 2. Sign in butonuna basin
        // 3. Login kutusuna “username” yazin
        // 4. Password kutusuna “password.” yazin
        // 5. Sign in tusuna basin
        // 6. Pay Bills sayfasina gidin
        // 7. “Purchase Foreign Currency” tusuna basin
        // 8. “Currency” drop down menusunden Eurozone’u secin
        // 9. “amount” kutusuna bir sayi girin
        // 10. “US Dollars” in secilmedigini test edin
        // 11. “Selected currency” butonunu secin
        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.


    static WebDriver driver;

    @BeforeClass

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

    }

    @AfterClass
    public static void tearDown() {

        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //Login alanine “username” yazdirin
        WebElement webLoginTextAlani = driver.findElement(By.xpath("//*[@id='user_login']"));
        webLoginTextAlani.sendKeys("username");
        Thread.sleep(1500);

        //4. Password alanine “password” yazdirin
        WebElement webPasswordTextAlani = driver.findElement(By.xpath("//*[@id='user_password']"));
        webPasswordTextAlani.sendKeys("password");
        Thread.sleep(1500);

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        Thread.sleep(1500);
        driver.navigate().back();

        //Pay Bills sayfasina gidin ( Bu sayfanın Linki yok, sayfa içi arama kısmından bulacağız )
        driver.findElement(By.xpath("//*[@id='searchTerm']")).sendKeys("Pay Bills", Keys.ENTER);
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[text()='Zero - Pay Bills']")).click();
        Thread.sleep(1500);

        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        Thread.sleep(1500);
        //“Currency” drop down menusunden Eurozone’u secin
        WebElement webCurrencyDropDown = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(webCurrencyDropDown);
        select.selectByValue("EUR");
        Thread.sleep(1500);

        //“amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("50");

        //“US Dollars” in secilmedigini test edin
        WebElement webUSdollarsRadioButon = driver.findElement(By.xpath("(//*[@class='radio inline'])[2]"));
        Assert.assertFalse(webUSdollarsRadioButon.isSelected());

        //“Selected currency” butonunu secin
        WebElement webSelectedCurrencyRadioButon = driver.findElement(By.xpath("(//*[@class='radio inline'])[3]"));
        webSelectedCurrencyRadioButon.click();
        Thread.sleep(1500);

        //“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@value='Purchase']")).click();
        Thread.sleep(1500);

        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement webForeignCurrencyUyariYazisi =driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertTrue(webForeignCurrencyUyariYazisi.isDisplayed());
        Thread.sleep(5000);


    }
}

