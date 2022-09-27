package Day11;

import utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Odev_0 extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        Actions action=new Actions(driver);

        // "http://webdriveruniversity.com/Actions" sayfasina gidin
       driver.get("http://webdriveruniversity.com/Actions");

        // Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst=driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));

        //  Link 1" e tiklayin
        action.moveToElement(hoverOverMeFirst).perform();
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();

        //  Popup mesajini yazdirin
        System.out.println("JS Uyarı Penceresi Mesajı :  " + driver.switchTo().alert().getText());

        //  Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //  “Click and hold" kutusuna basili tutun
       WebElement clickandHold= driver.findElement(By.xpath("//*[@id='click-box']"));
       action.clickAndHold(clickandHold).perform();

        //  “Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold Penceresi Mesajı :  " + driver.findElement(By.xpath("//*[@id='click-box']")).getText());

        //  “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe=driver.findElement(By.xpath("//*[@id='double-click']"));
        action.doubleClick(doubleClickMe).perform();

        Thread.sleep(5000);
    }
}
