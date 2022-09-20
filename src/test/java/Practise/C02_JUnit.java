package Practise;

import org.junit.*;

public class C02_JUnit {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @After
    public void After(){
        System.out.println("After");
    }

    @Before
    public void before(){
        System.out.println("Before");
    }

    @Test
    public void test01() {
        System.out.println("Test 01");
    }

    @Test
    public void test02() {
        System.out.println("Test 02");
    }

    @Test
    public void test03() {
        System.out.println("Test 03");
    }
}
