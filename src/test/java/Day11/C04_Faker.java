package Day11;

import utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_Faker extends TestBaseBeforeAfter {
    // Faker objesi pom.xml'e https://mvnrepository.com/artifact/com.github.javafaker/javafaker
    // eklenen method sayesinde random - fake objeler üretir.


    @Test
    public void test1() {

        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        Actions actions = new Actions(driver);

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        WebElement isim = driver.findElement(By.xpath("//*[@name='firstname']"));

               actions.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()). sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1982").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }
}
