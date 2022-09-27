package Day13;

import utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Bir önceki class'daki adrese gidelim
        //Login() methodunu kullanarak sayfaya giriş yapalım
        login();
        int satir = 3;
        int sutun = 4;
        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        WebElement cell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Satır ve sutundaki text : "+cell.getText());
        //Price başlığındaki tum numaraları yazdırınız
        List<WebElement> priceBasligi = driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement w:priceBasligi) {
            System.out.println(w.getText());
        }
    }


    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

}
