package Practise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_Practise extends TestBaseBeforeAfter {
    @Test
    public void name() {


        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']")); // iframe vardı
        driver.switchTo().frame(iframe);
        // tüm hayvan emojilerine tıklayın
        List<WebElement> animalsemoji = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));

        //  for (WebElement w : animalsemoji) {
        //      w.click();
        //  }
        animalsemoji.forEach(t -> t.click());

        driver.switchTo().defaultContent(); // iframe den çıkış yapılmalı

        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> inputListesi = driver.findElements(By.xpath("(//input)")); // 11 adet var
        List<String> text = new ArrayList<>
                (Arrays.asList("Bu", "Form", "Öylesine", "Doldurduk", "ama", "sadece", "öylesine", "iş", "olsun", "diye", "yaptık"));
       // for (int i = 0; i < text.size(); i++) {
       //     inputListesi.get(i).sendKeys(text.get(i));
       // }
        for (int i = 1; i <= text.size(); i++) {
            driver.findElement(By.xpath("(//input)["+i+"]")).sendKeys(text.get(i-1));
        }

        // apply butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='send']")).click();
    }
}