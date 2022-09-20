package Practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GMIBankLogin {
    public static void main(String[] args) {
        // 1) GMI Bank "https://www.gmibank.com" adresine gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.gmibank.com");

        // Sign Tıkla
        driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-user fa-w-14 ']")).click();

        // Açılan pencerede "Sign in" yazısına tıkla
        driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();

        // Açılan pencerede Username : "Batch81"  ve Pasword : girin
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Batch81");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Batch81+");
        driver.findElement(By.xpath("(//*[text()='Sign in'])[4]")).click();


    }
}
