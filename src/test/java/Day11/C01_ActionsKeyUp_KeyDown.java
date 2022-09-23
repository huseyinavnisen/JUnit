package Day11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_ActionsKeyUp_KeyDown extends TestBaseBeforeAfter {

   //alt + insert bastık @Test oluşturur

    @Test
    public void test1() throws InterruptedException {
        // https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com ");
        Actions action = new Actions(driver);
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        // Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        action.click(aramaKutusu).sendKeys("samsung ").
                keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("71").sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        /*
        KeysDown.SHIFT  == > Shift Tuşuna Basar
        KeysUp.SHIFT ==> Shift Tuşunu Bırakır
         */

        // aramanin gerceklestigini test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());
    }


}
