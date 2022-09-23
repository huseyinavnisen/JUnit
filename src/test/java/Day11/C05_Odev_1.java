package Day11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C05_Odev_1 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        Actions action = new Actions(driver);

        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/ ");

        // video’yu gorecek kadar asagi inin
        WebElement baslikYazisi = driver.findElement(By.xpath("//*[@class='site-title']"));
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        // videoyu izlemek icin Play tusuna basin
        List<WebElement> iframe = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframe.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

        // videoyu calistirdiginizi test edin
        WebElement videoBaslikYazisi = driver.findElement(By.xpath("//*[text()='Massive volcanoes & Flamingo colony - Wild South America - BBC']"));
        System.out.println("Çalışan Videonun Başlık Yazısı = " + videoBaslikYazisi.getText());
        Assert.assertTrue(videoBaslikYazisi.isDisplayed());
    }

}
