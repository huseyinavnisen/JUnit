package Day12;

import utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Automationexercise.com sitesine gidelim
        driver.get("https://automationexercise.com/");
        //product bolumune giorelim

        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        //ilk urunu secelim
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
    }
}
