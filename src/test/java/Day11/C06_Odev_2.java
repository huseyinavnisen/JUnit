package Day11;

import utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

public class C06_Odev_2 extends TestBaseBeforeAfter {
    Actions action = new Actions(driver);

    @Test
    public void name() {
        // Test-1
        // amazon gidin
        driver.get("http://amazon.com");
        driver.navigate().refresh();

        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        // dropdown menude 40 eleman olduğunu doğrulayın

        //Test02
        // dropdown menuden elektronik bölümü seçin

        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        // sonuc sayisi bildiren yazinin iphone icerdigini test edin
        // ikinci ürüne relative locater kullanarak tıklayin
        // ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

        // Test03
        // yeni bir sekme açarak amazon anasayfaya gidin
        // dropdown’dan bebek bölümüne secin
        // bebek puset aratıp bulundan sonuç sayısını yazdırın
        // sonuç yazsının puset içerdiğini test edin
        // 5-üçüncü ürüne relative locater kullanarak tıklayin
        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

        // Test 4
        // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}