package Day10;

import utilities.TestBaseBeforeAfter;
import org.junit.Test;

public class C01_TestBase extends TestBaseBeforeAfter {
   @Test
   public void test1(){
       driver.get("http://amazon.com");
   }

}
