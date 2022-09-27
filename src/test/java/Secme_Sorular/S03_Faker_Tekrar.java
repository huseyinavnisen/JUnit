package Secme_Sorular;

import utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class S03_Faker_Tekrar extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        Faker faker = new Faker();
        Actions actions = new Actions(driver);

        //1. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //2. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //3. Yeni Kullanıcı Kaydı Kısmında; Adı ve e-posta adresini girin ve 'Kaydol' düğmesine tıklayın
        WebElement nameKutusu = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        actions.click(nameKutusu).sendKeys(faker.name().username()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        //4. 'ENTER ACCOUNT INFORMATION' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("(//b)[1]")).isDisplayed());

        //5. Doldurma ayrıntıları:
        // Mrs; Pasword( fake ), Doğum tarihi girin
        // 'Sign up for our newsletter!' seçin; 'Receive special offers from our partners!' onay kutusunu seçmeyin
        // Create Account butonuna kadarki kutucuklara ( First Name, Last name, Company gibi ) Fake bilgi girin.
        // Not : Country olarak "Canada" girin
        Thread.sleep(2000);
        WebElement OnayKutusu = driver.findElement(By.xpath("//*[@for='id_gender2']"));
        actions.click(OnayKutusu).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).perform();
        WebElement ddmDay = driver.findElement(By.xpath("//*[@id='days']"));
        Select select = new Select(ddmDay);
        select.selectByVisibleText("10");

        actions.click(ddmDay).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("May").sendKeys(Keys.TAB).
                sendKeys("2002").sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).sendKeys(Keys.TAB).
                sendKeys(faker.address().secondaryAddress()).sendKeys(Keys.TAB).
                sendKeys(faker.address().secondaryAddress()).sendKeys(Keys.TAB).
                sendKeys("Canada").sendKeys(Keys.TAB).
                sendKeys(faker.address().state()).sendKeys(Keys.TAB).
                sendKeys(faker.address().city()).sendKeys(Keys.TAB).
                sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();



        //7- 'Create Account düğmesine' tıklayın

        //8. 'ACCOUNT CREATED!' yazısının göründüğünü onaylayın

    }

}

