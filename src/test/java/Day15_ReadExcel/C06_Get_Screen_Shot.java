package Day15_ReadExcel;

import utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class C06_Get_Screen_Shot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        // amazon sayfasına gidelim ve tüm sayfanın resmini alalım
        driver.get("https://amazon.com");

        /*
        bir web sayfasının resmini alabilmek için TakesScreenshot clasından bir obje oluşturup geçici
        bir File clasından değişkene TakesScrrenShot'dan oluşturduğumuz obje'den getScreenshotAs(OutputType.FILE);
        methodunu kullanarak geçici bir file oluştururuz.
                 */

        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));




    }
}
