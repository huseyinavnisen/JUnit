package Secme_Sorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class S01_WindowHandles {
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

        // 3 - Aynı Pencerede yeni TAB sekmesinde hhtp://www.hepsiburada.com sayfasını açın
        driver.switchTo().newWindow(WindowType.TAB).get("https://hepsiburada.com");

        // 4 - Yeni bir pencerede "https://amazon.com" sayfasını açın
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://amazon.com");

        // 5 - amazon.com sayfasında arama kısmında "Mouse" arayın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("mouse", Keys.ENTER);

        // 6- Bulduğu ürünlerden ilk ürünün adında "Mouse" kelimesinin geçtiğini doğrulayın
        String ilkBulunanUrun = driver.findElement(By.xpath("//*[text()='Amazon Basics 3-Button Wired USB Computer Mouse, Black']")).getText();
        Assert.assertTrue(ilkBulunanUrun.contains("Mouse"));

        // 7 - Yeni bir pencerede "http://asrateknik.com" sayfasını  açın
        driver.switchTo().newWindow(WindowType.WINDOW).get("http://asrateknik.com");

        // 8 - Ürünler menüsünden "Ameliyathane Hijyen Santralleri" kısmına tıklayın
        WebElement menu= driver.findElement(By.xpath("//*[text()='Ürünler']"));
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();

        driver.findElement(By.xpath("(//*[text()='Ameliyathane Hijyen Santralleri'])[1]")).click();

        // 9 - Ameliyathane Hijyen Santralleri sayfasında; "İki Bölgeli Klima sistemi" yazısının göründüğünü test edin.
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[4]")).isDisplayed());

        //  10 - İlk penceredeki hepsiburada.com sayfasına dönün.
        List<String> handleCode1 = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i <handleCode1.size() ; i++) {
            System.out.println("1.Handle List, index  "+i+" ==>  "+ driver.switchTo().window(handleCode1.get(i)).getCurrentUrl());
        }
        driver.switchTo().window(handleCode1.get(1));

        // 11 - hepsiburada sayfasında Arama kısmında "Notebook" arayın
        driver.findElement(By.xpath("//*[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")).sendKeys("Notebook", Keys.ENTER);
        Thread.sleep(2000);

        // 12 - Notebook ile ilgili 1000+ sonuç bulundu yazısının göründüğünü onaylayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='searchResultSummaryBar-AVnHBWRNB0_veFy34hco']")).isDisplayed());

        // 13 - amazon.com sayfasının olduğu pencereye dönün ve pencereyi kapatın
        driver.switchTo().window(handleCode1.get(2));
        driver.close();

        // 14 -İlk açtığınız https://the-internet.herokuapp.com/windows" sayfasına geçin.
        driver.switchTo().window(handleCode1.get(0));

        // 15 - Click Here yazısına tıklayın
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //16 -  Açılan yeni sekmedeki yeni sayfada "New Window" yazısının göründüğünü onaylayın.
        System.out.println("---------------------");
        List<String> handleCode2 = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i <handleCode2.size() ; i++) {
            System.out.println("2.Handle List: index  "+i+" ==>  "+ driver.switchTo().window(handleCode2.get(i)).getCurrentUrl());
        }

        driver.switchTo().window(handleCode2.get(3));
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());


    }
}