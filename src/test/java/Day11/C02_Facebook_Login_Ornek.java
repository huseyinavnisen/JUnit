package Day11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Facebook_Login_Ornek extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        Actions actions= new Actions(driver);

        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimGir=driver.findElement(By.xpath("//*[@name=\"firstname\"]"));
        isimGir.sendKeys("Hüseyin");
        actions.sendKeys(Keys.TAB).sendKeys("Şen");
        actions.sendKeys(Keys.TAB).sendKeys("0532-5788061");
        actions.sendKeys(Keys.TAB).sendKeys("YeniŞifrem61");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB).sendKeys("13");
        actions.sendKeys(Keys.TAB).sendKeys("Ağu");
        actions.sendKeys(Keys.TAB).sendKeys("1975");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.RIGHT);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB).perform();



        // 4- Kaydol tusuna basalim
    }
}
