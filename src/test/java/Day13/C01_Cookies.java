package Day13;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // 1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");


        // 2-tum cookie’leri listeleyin
        Set<Cookie> tumCookie = driver.manage().getCookies();
        System.out.println(tumCookie);
        int sayac = 1;
        for (Cookie w : tumCookie) {
            System.out.println(sayac + ".ci cookie : " + w);
            System.out.println(sayac + ".ci name   : " + w.getName());
            System.out.println(sayac + ".ci value  : " + w.getValue());
            System.out.println("...................");
            sayac++;
        }

        // 3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookiesSayisi = tumCookie.size();
        Assert.assertTrue(cookiesSayisi > 5);

        // 4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w : tumCookie) {
            if (w.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", w.getValue());
            }

        }
        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);

        System.out.println("Cookies 2. liste");
        tumCookie = driver.manage().getCookies();
        System.out.println(tumCookie);
        sayac = 1;
        for (Cookie w : tumCookie) {
            System.out.println(sayac + ".ci cookie : " + w);
            System.out.println(sayac + ".ci name   : " + w.getName());
            System.out.println(sayac + ".ci value  : " + w.getValue());
            System.out.println("...................");
            sayac++;
        }
        // 6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookie.contains(yeniCookie));

        // 7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        System.out.println("Cookies 3. liste");
        tumCookie = driver.manage().getCookies();
        System.out.println(tumCookie);
        sayac = 1;
        for (Cookie w : tumCookie) {
            System.out.println(sayac + ".ci cookie : " + w);
            System.out.println(sayac + ".ci name   : " + w.getName());
            System.out.println(sayac + ".ci value  : " + w.getValue());
            System.out.println("...................");
            sayac++;
        }
        Assert.assertFalse(tumCookie.contains("skin"));

        // 8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie = driver.manage().getCookies();
        Assert.assertTrue(tumCookie.isEmpty());

    }
}
