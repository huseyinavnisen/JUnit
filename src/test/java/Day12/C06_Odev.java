package Day12;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class C06_Odev extends TestBaseBeforeAfter {


    @Test
    public void odev2() {

        // "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // "Our Products" butonuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe"))); // iframe girdik
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        // "Cameras product"i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        // Popup mesajini yazdirin
        System.out.println("Popup Mesajı :  " + driver.switchTo().alert().getText());

        // "close" butonuna basin
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent(); // iframe den çıktık

        // "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("WebdriverUniversity.com (IFrame)")).click();

        // "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        Assert.assertTrue(actualUrl.equals(expectedUrl));

        Assert.assertEquals(driver.getCurrentUrl(),"http://webdriveruniversity.com/index.html");
    }


}
