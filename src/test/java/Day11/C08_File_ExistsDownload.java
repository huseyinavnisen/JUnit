package Day11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_File_ExistsDownload extends TestBaseBeforeAfter {
    @Test
    public void isExist() throws InterruptedException {

        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='Test.txt']")).click();
        Thread.sleep(5000);

        // Ardından dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Hüseyin\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println(Files.exists(Paths.get(dosyaYolu)));


    }

}
