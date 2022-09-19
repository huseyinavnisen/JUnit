package AE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DropDown {
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

        //Login alanına “username” yazdirin

        //4. Password alanine “password” yazdirin

        //5. Sign in buttonuna tiklayin

        //Pay Bills sayfasina gidin ( Bu sayfanın Linki yok, sayfa içi arama kısmından bulacağız )

        //“Purchase Foreign Currency” tusuna basin

        //“Currency” drop down menusunden Eurozone’u secin

        //“amount” kutusuna bir sayi girin Örneğin : 50

        //“US Dollars”'in secilmedigini test edin

        //“Selected currency” butonunu secin

        //“Calculate Costs” butonuna basin sonra “purchase” butonuna basin

        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

    }
}

