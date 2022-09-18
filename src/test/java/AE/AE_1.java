package AE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AE_1 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void after() {
        //   driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement homePage = driver.findElement(By.xpath("//*[@id='slider']"));
        if (homePage.isDisplayed()) {
            System.out.println("HomePage Test PASSED");
        } else {
            System.out.println("HomePage Test FAILED");
        }
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        WebElement signin = driver.findElement(By.xpath("//*[@href=\"/login\"]"));
        signin.click();
        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        WebElement bulunanYeniKullaniciKaydiYazisi = driver.findElement(By.xpath("(//h2)[3]"));
        String gercekNewUserSignupYazisi = "New User Signup!";
        if (bulunanYeniKullaniciKaydiYazisi.getText().contains(gercekNewUserSignupYazisi)) {
            System.out.println("Ekranda " + gercekNewUserSignupYazisi + " Yazısı Var; TEST PASSED");
        } else System.out.println("Ekranda " + gercekNewUserSignupYazisi + " Yazısı Yok; TEST FAILED");

        //6. Adı ve e-posta adresini girin
        WebElement LocateName = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        WebElement LocateEmail = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        String kullaniciAdi = "huseyin";
        LocateName.sendKeys(kullaniciAdi);
        LocateEmail.sendKeys("has55wee@gmail.com");

        //7. 'Kaydol' düğmesini tıklayın
        WebElement LocateSignUpButon = driver.findElement(By.xpath("//*[@data-qa='signup-button']"));
        Thread.sleep(2000);
        LocateSignUpButon.click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        WebElement gercekHesapBilgileriniGirinIfadesi = driver.findElement(By.xpath(" (//h2)[1]"));
        if (gercekHesapBilgileriniGirinIfadesi.isDisplayed()) {
            System.out.println("HESAP BİLGİLERİNİ GİRİN ifadesi göründü. TEST PASSED");
        } else System.out.println("HESAP BİLGİLERİNİ GİRİN ifadesi görünmedi. TEST FAILED");


        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi

        driver.findElement(By.xpath("//*[@id='id_gender2']")).click(); // bay - Bayan
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12345678"); // pasword

        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("13");
        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("August");
        driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1975");
Thread.sleep(3000);
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[text()='Sign up for our newsletter!']")).click();
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[text()='Receive special offers from our partners!']")).click();
        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Hüseyin");
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Şen");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Asra Teknik");
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Kazım Karabekir Cad.");
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("Eye Apt.");
        driver.findElement(By.xpath("//*[@id='country']")).sendKeys("Turkey");
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Yukarı Toronto");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("TORONTO");
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("61300");
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("0532 - 578 80 61");
        Thread.sleep(1000);

        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();

        //14. 'HESAP OLUŞTURULDU!' görünür
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (accountCreated.isDisplayed()) {
            System.out.println("Account Created! yazısı görüldü; TEST PASSED");
        } else System.out.println("Account Created! yazısı görülmedi; TEST FAILED");
        Thread.sleep(1000);
        //15. 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement oturumAcildi = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        if (oturumAcildi.isDisplayed()) {
            System.out.println("Oturum Açıldı yazısı görüldü; TEST PASSED");
        } else System.out.println("Oturum Açıldı yazısı görülmedi; TEST FAILED");
        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
        WebElement hesapSilindiYazisi = driver.findElement(By.xpath("//h1"));


    }


}

