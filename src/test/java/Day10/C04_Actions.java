package Day10;

import utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {


    @Test
    public void test1() {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Çizili alan uzerinde sag click yapalim

        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();


        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

        String JSmesaj = driver.switchTo().alert().getText();
        String arananMesaj = "You selected a context menu";
        Assert.assertTrue(JSmesaj.equals(arananMesaj));

        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> HandleCode = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(HandleCode.get(1));
        String webdekiYazi= driver.findElement(By.xpath("//h1")).getText();
        Assert.assertTrue(webdekiYazi.equals("Elemental Selenium"));


    }


}
