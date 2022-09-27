package Day13;

import utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;

public class C04_Odev1 extends TestBaseBeforeAfter {
    @Test
    public void name() {


        // https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        // Username : manager  ○ Password : Manager2!
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        // table( ) metodu oluşturun
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        // Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        // printRows( ) metodu oluşturun //tr
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        // 4.satirdaki(row) elementleri konsolda yazdırın.
        // printCells( ) metodu oluşturun //td
        // table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        // Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        // printColumns( ) metodu oluşturun
        // table body’sinde bulunan toplam sutun(column) sayısını bulun.
        // Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        // 5.column daki elementleri konsolda yazdırın.
    }
}
