package AutomationExerciseQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase1_RegisterUser {
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'New User Signup!' is visible
        6. Enter name and email address
        7. Click 'Signup' button
        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        9. Fill details: Title, Name, Email, Password, Date of birth
        10. Select checkbox 'Sign up for our newsletter!'
        11. Select checkbox 'Receive special offers from our partners!'
        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        13. Click 'Create Account button'
        14. Verify that 'ACCOUNT CREATED!' is visible
        15. Click 'Continue' button
        16. Verify that 'Logged in as username' is visible
        17. Click 'Delete Account' button
        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    //3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.xpath("//*[@id='slider']"));
        if (homePage.isDisplayed()){
            System.out.println("HomePage Test PASSED"); //ctrl+shift+/ ile paragrafi yoruma al
        }else{
            System.out.println("HomePage Test FAILED");
        }
        //Assert.assertFalse(homePage.isDisplayed());

    //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

    //5. Verify 'New User Signup!' is visible
        WebElement NewUserSignUp=driver.findElement(By.xpath("(//h2)[3]"));
        if (NewUserSignUp.isDisplayed()){
            System.out.println("New User SignUp Test PASSED");
        }else {
            System.out.println("New User SignUp Test FAILED");
        }

    //6. Enter name and email address
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Michael Schumacher");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("Msc07@formula1.com");

    //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement visibleOfEnter= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (visibleOfEnter.isDisplayed()){
            System.out.println("Visible of Enter Test PASSED");
        }else {
            System.out.println("Visible of Enter Test FAILED");
        }

    //9. Fill details: Title, Name, Email, Password, Date of birth

        //Title
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();

        //Password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456789");

        //Date of birth
        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("3");
        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("January");
        driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1969");

    //10. Select checkbox 'Sign up for our newsletter!'
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@value='1'])[1]")).click();
        //driver.findElement(By.xpath("//*[@id='newsletter']")).click();

    //11. Select checkbox 'Receive special offers from our partners!'
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@value='1'])[2]")).click();
        //driver.findElement(By.xpath("//*[@id='optin']")).click();

    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        //First name
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Michael");

        //Last name
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Schumacher");

        //Company
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Formula1");

        //Address
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Michael Schumacher, Roslagsgatan 10");

        //Adress2
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Gland");

        //Country
        driver.findElement(By.xpath("//select[@id='country']")).sendKeys("Canada");

        //State
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Center Europe");

        //City
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Stockholm");

        //Zipcode
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("117");

        //Mobile Number
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("+49 1111-123456");

    //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[text()='Create Account']")).sendKeys(Keys.ENTER);

    //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated=driver.findElement(By.xpath("//b"));
        if (accountCreated.isDisplayed()){
            System.out.println("Account Created Test PASSED");
        }else {
            System.out.println("Account Created Test FAILED");
        }

    //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

    //16. Verify that 'Logged in as username' is visible
        WebElement loggedUsername=driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        if (loggedUsername.isDisplayed()){
            System.out.println("Logged Username Test PASSED");
        }else {
            System.out.println("Logged Username Test FAILED");
        }

    //17. Click 'Delete Account' button
        driver.findElement(By.xpath("(//*[@style='color:brown;'])[2]")).click();

    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        WebElement accountDeleted=driver.findElement(By.xpath("(//*[text()='Delete Account'])[2]"));
        if (accountDeleted.isDisplayed()){
            System.out.println("Account Deleted Test PASSED");
        }else {
            System.out.println("Account Deleted Test FAILED");
        }
    }
}
