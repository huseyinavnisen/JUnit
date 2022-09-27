package Day12;

import utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_Dosya_Upload extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // chooseFile butonuna basalim
        WebElement buton = driver.findElement(By.xpath("//*[@id='file-upload']"));
         /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string değişkene atadığımız dosya yolumuzu
        göndeririz.
         */

        // Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\Hüseyin\\Desktop\\text.txt";
        buton.sendKeys(dosyaYolu);

        // Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        // “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='uploaded-files']")).isDisplayed());
    }
}
