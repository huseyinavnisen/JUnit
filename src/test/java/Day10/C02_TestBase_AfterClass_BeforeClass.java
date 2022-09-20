package Day10;

import Utilities.TestBaseBeforeClassAfterClass;
import org.junit.Test;

public class C02_TestBase_AfterClass_BeforeClass extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1(){
        driver.get("http://amazon.com");
    }
}
