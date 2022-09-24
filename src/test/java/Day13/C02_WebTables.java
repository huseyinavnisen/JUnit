package Day13;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        login();
        table();
    }
    private void login() {
        // https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        // Username : manager   // Password : Manager1!

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    private void table() {
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayısı = " + sutunSayisi.size());

        // Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Başlıklar :" + basliklar.getText());

        WebElement tumBady = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tüm Body = " + tumBady.getText());

        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki Satır Sayısı = " + satirSayisi.size());

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirSayisi.forEach(t-> System.out.println(t.getText()));

        // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4.SATIRDAKi ELEMENTLER :"+ driver.findElement(By.xpath("//tbody//tr[4]")).getText());

    }




}
