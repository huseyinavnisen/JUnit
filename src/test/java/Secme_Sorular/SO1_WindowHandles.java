package Secme_Sorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SO1_WindowHandles {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        // 1 - https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // 2 - Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        // 3 - Aynı TAB sekmesinde hhtp://www.hepsiburada.com sayfasını açın
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://hepsiburada.com");

        // 4 - Yeni bir pencerede "https://amazon.com" sayfasını açın
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com");

        // 5 - amazon.com sayfasında arama kısmında "Mouse" arayın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("mouse", Keys.ENTER);

        // 6- Bulduğu ürünlerden ilk ürünün adında "Mouse" kelimesinin geçtiğini doğrulayın
        String ilkBulunanUrun = driver.findElement(By.xpath("//*[text()='Amazon Basics 3-Button Wired USB Computer Mouse, Black']")).getText();
        Assert.assertTrue(ilkBulunanUrun.contains("Mouse"));

        // 7 - Yeni bir pencerede "http://asrateknik.com" sayfasını  açın
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://asrateknik.com");

        // 8 - Ürünler menüsünden "Ameliyathane Hijyen Santralleri" kısmına tıklayın
        driver.findElement(By.xpath(" //*[text()='Ürünler']")).click();
        driver.findElement(By.xpath("(//*[text()='Ameliyathane Hijyen Santralleri'])[1]")).click();

        // 9 - Ameliyathane Hijyen Santralleri sayfasında; "İki Bölgeli Klima sistemi" yazısının göründüğünü test edin.
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[4]")).isDisplayed());

        //  10 - İlk penceredeki hepsiburada.com sayfasına dönün.
        List<String> webSayfalariHandleCode1 = new ArrayList<>(driver.getWindowHandles());
        System.out.println(driver.switchTo().window(webSayfalariHandleCode1.get(0)).getCurrentUrl()); // https://the-internet.herokuapp.com/windows
        System.out.println(driver.switchTo().window(webSayfalariHandleCode1.get(1)).getCurrentUrl()); // https://www.hepsiburada.com/
        System.out.println(driver.switchTo().window(webSayfalariHandleCode1.get(2)).getCurrentUrl()); // https://www.amazon.com/s?k=mouse&ref=nb_sb_noss
        System.out.println(driver.switchTo().window(webSayfalariHandleCode1.get(3)).getCurrentUrl()); // https://asrateknik.com/ameliyathane-hijyen-santralleri/

        driver.switchTo().window(webSayfalariHandleCode1.get(1));

        // 11 - hepsiburada sayfasında Arama kısmında "Notebook" arayın
        driver.findElement(By.xpath("//*[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")).sendKeys("Notebook", Keys.ENTER);
        Thread.sleep(2000);

        // 12 - Notebook ile ilgili 1000+ sonuç bulundu yazısının göründüğünü onaylayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='searchResultSummaryBar-AVnHBWRNB0_veFy34hco']")).isDisplayed());

        // 13 - amazon.com sayfasının olduğu pencereye dönün ve pencereyi kapatın
        driver.switchTo().window(webSayfalariHandleCode1.get(2));
        driver.close();

        // 14 -İlk açtığınız https://the-internet.herokuapp.com/windows" sayfasına geçin.
        driver.switchTo().window(webSayfalariHandleCode1.get(0));

        // 15 - Click Here yazısına tıklayın
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();


        //16 -  Açılan yeni sekmedeki yeni sayfada "New Window" yazısının göründüğünü onaylayın.
        System.out.println("---------------------");
        List<String> webSayfalariHandleCode2 = new ArrayList<>(driver.getWindowHandles());
        System.out.println(driver.switchTo().window(webSayfalariHandleCode2.get(0)).getCurrentUrl()); // https://the-internet.herokuapp.com/windows
        System.out.println(driver.switchTo().window(webSayfalariHandleCode2.get(1)).getCurrentUrl()); // https://www.hepsiburada.com/ara?q=Notebook
        System.out.println(driver.switchTo().window(webSayfalariHandleCode2.get(2)).getCurrentUrl()); // https://asrateknik.com/ameliyathane-hijyen-santralleri/
        System.out.println(driver.switchTo().window(webSayfalariHandleCode2.get(3)).getCurrentUrl()); // https://the-internet.herokuapp.com/windows/new

        driver.switchTo().window(webSayfalariHandleCode2.get(3));
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        System.out.println("----------------");
         System.out.println(driver.switchTo().window(webSayfalariHandleCode1.get(0)).getCurrentUrl());
         System.out.println(driver.switchTo().window(webSayfalariHandleCode1.get(1)).getCurrentUrl());
         System.out.println(driver.switchTo().window(webSayfalariHandleCode1.get(3)).getCurrentUrl());


    }
}