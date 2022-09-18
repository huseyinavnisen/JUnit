package Day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {

   // https://the-internet.herokuapp.com/dropdown adresine gidin.
   // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
   // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
   // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
   // Tüm dropdown değerleri(value) yazdırın
   // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
   // False yazdırın.

    WebDriver driver;
    Select select;


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown ");
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() {
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        select = new Select(ddm);

        // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
       // System.out.println(select.getOptions().get(1).getText());
        System.out.println(select.getFirstSelectedOption().getText());

        // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddmList=select.getOptions();
        for (WebElement w:ddmList) {
            System.out.println(w.getText());
        }
        // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int ddmNumber=ddmList.size();
        int a=4;
        if (ddmNumber==a){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
