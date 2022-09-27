package Secme_Sorular;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.*;

public class S04_Excel extends TestBaseBeforeAfter {
    @Test
    public void name() throws IOException {
        // 1 - resources klasöründeki "testData.xlsx" dosyası, Sheet1 sayfasın üzerinde çalışılacaktır.
        // 2 - Bu Excel dökümanı Sheet1 sayfasında 2. satır, 1.sütunundaki ( A2 ) URL bilgisini bir String değişkene aktarın.
        // 3 - Sayfadaki 2.satırdaki "Kullanıcı Adı" hücresindeki veriyi ( B2 ) bir Stringe aktarın.
        // 4 - Sayfadaki 2.satırdaki "Şifre" hücresindeki veriyi ( C2 ) bir Stringe aktarın.
        // 5 - Excel sayfasındaki istenen URL'ye gidin.
        // 6 - Açılan URL'de User Name ve Pasword kısmına, excel dosyasından aldığınız bilgileri girin. Giriş'e basın
        // 7 - Login olduğunuzu doğrulayın ( Mesela; LIST OF HOTELROOMS yazısı görünüyor ise Login olmuşsunuz demektir )
        // 8 - Login olduğunuz sayfanın ekren resmini alın ve target/screenShot klasörüne kaydedin.
        // 9 - Excel sayfasında 2. Satır 4.Sütuna ( D2 ); "TEST PASSED" yazdırın.
        // 10 - Excel sayfasında 2. Satır 5.Sütuna ( E2 ); ekran resminin dosya adını yazdırın.
        // 11 - Üzerine veri eklediğiniz Excel dosyasını kaydedin.


        // 1 - resources klasöründeki "testData.xlsx" dosyası, Sheet1 sayfasın üzerinde çalışılacaktır.
        String dosyaYolu = "src/resources/testData.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        // 2 - Bu Excel dökümanı Sheet1 sayfasında 2. satır, 1.sütunundaki ( A2 ) URL bilgisini bir String değişkene aktarın.
        String url = workbook.getSheet("Sheet1").getRow(1).getCell(0).toString();
        System.out.println(url);
        // 3 - Sayfadaki 2.satırdaki "Kullanıcı Adı" hücresindeki veriyi ( B2 ) bir Stringe aktarın.
        String userName = workbook.getSheet("Sheet1").getRow(1).getCell(1).toString();
        System.out.println(userName);
        // 4 - Sayfadaki 2.satırdaki "Şifre" hücresindeki veriyi ( C2 ) bir Stringe aktarın.
        String pasword = workbook.getSheet("Sheet1").getRow(1).getCell(2).toString();
        System.out.println(pasword);
        // 5 - Excel sayfasındaki istenen URL'ye gidin.
        driver.get(url);
        // 6 - Açılan URL'de User Name ve Pasword kısmına, excel dosyasından aldığınız bilgileri girin. Giriş'e basın
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(pasword);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        // 7 - Login olduğunuzu doğrulayın ( Mesela; LIST OF HOTELROOMS yazısı görünüyor ise Login olmuşsunuz demektir )
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='List Of Hotelrooms'])[2]")).isDisplayed());
        // 8 - Login olduğunuz sayfanın ekren resmini alın ve target/screenShot klasörüne kaydedin.
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/screenShot/AllPage" + tarih + ".jpeg"));
        // 9 - Excel sayfasında 2. Satır 4.Sütuna ( D2 ); "TEST PASSED" yazdırın.
        workbook.getSheet("Sheet1").getRow(1).createCell(3).setCellValue("TEST PASSED");
        // 10 - Excel sayfasında 2. Satır 5.Sütuna ( E2 ); ekran resminin dosya adını yazdırın.
        workbook.getSheet("Sheet1").getRow(1).createCell(4).setCellValue("target/screenShot/AllPage" + tarih + ".jpeg");

        // 11 - Üzerine veri eklediğiniz Excel dosyasını kaydedin.
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();


    }
}
