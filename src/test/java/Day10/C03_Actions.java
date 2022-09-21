package Day10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        // Amazona git
        driver.get("https://www.amazon.com");

        // Account menüsünden "create a list" e tıklayın
        WebElement accountList= driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        Actions action = new Actions(driver);
        action.moveToElement(accountList).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();


    }
}
