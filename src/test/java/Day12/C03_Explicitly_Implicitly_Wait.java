package Day12;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C03_Explicitly_Implicitly_Wait extends TestBaseBeforeAfter {
    @Test
    public void WaitTest() {

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 7. It's back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's back!\"]")).isDisplayed());
    }

    @Test
    public void explicitWait() {
/*
Bu test çalışmadan önce @Beforeclass taki
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) kısmını yoruma alacağızki
explicitWait() methodunun etkisini görebilelim.
 */

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsGoneWE.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 7. It's back mesajinin gorundugunu test edin
        WebElement itsBackWE=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackWE.isDisplayed());

    }
}
