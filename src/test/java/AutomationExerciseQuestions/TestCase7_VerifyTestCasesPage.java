package AutomationExerciseQuestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class TestCase7_VerifyTestCasesPage extends TestBaseBeforeAfter {

   // 1. Launch browser
   // 2. Navigate to url 'http://automationexercise.com'
   // 3. Verify that home page is visible successfully
   // 4. Click on 'Test Cases' button
   // 5. Verify user is navigated to test cases page successfully


    @Test
    public void test1() {

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        Assert.assertTrue("Page is visible", driver.getCurrentUrl().contains("https://automationexercise.com/"));
        // 4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
        // 5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Test Cases']")).isDisplayed());
    }
}
