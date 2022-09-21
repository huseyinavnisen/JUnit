package Secme_Sorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S01_WindowHandles_Tekrar {
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

        // 2 - Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        // 3 - Aynı TAB sekmesinde hhtp://www.hepsiburada.com sayfasını açın

        // 4 - Yeni bir pencerede "https://amazon.com" sayfasını açın

        // 5 - amazon.com sayfasında arama kısmında "Mouse" arayın

        // 6- Bulduğu ürünlerden ilk ürünün adında "Mouse" kelimesinin geçtiğini doğrulayın

        // 7 - Yeni bir pencerede "http://asrateknik.com" sayfasını  açın

        // 8 - Ürünler menüsünden "Ameliyathane Hijyen Santralleri" kısmına tıklayın

        // 9 - Ameliyathane Hijyen Santralleri sayfasında; "İki Bölgeli Klima sistemi" yazısının göründüğünü test edin.

        //  10 - İlk penceredeki hepsiburada.com sayfasına dönün.

        // 11 - hepsiburada sayfasında Arama kısmında "Notebook" arayın

        // 12 - Notebook ile ilgili 1000+ sonuç bulundu yazısının göründüğünü onaylayın

        // 13 - amazon.com sayfasının olduğu pencereye dönün ve pencereyi kapatın

        // 14 -İlk açtığınız https://the-internet.herokuapp.com/windows" sayfasına geçin.

        // 15 - Click Here yazısına tıklayın

        // 16 - Açılan yeni sekmedeki yeni sayfada "New Window" yazısının göründüğünü onaylayın.

    }
}