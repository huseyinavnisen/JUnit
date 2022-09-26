package Day15_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void name() throws IOException {


        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
        int sonSatir=workbook.getSheet("Sayfa2").getLastRowNum(); // index o dan başlar + 1 eklenmeli
        System.out.println("Sayfa2'de En Son Kullanılan Satır Sayısı = " +sonSatir);

        Assert.assertEquals(6,sonSatir);


        int iciDoluHucreSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows(); // içi dolu satırlar
        System.out.println("Sayfa2'de Kullanılan İçi Dolu Satır Sayısı= " + iciDoluHucreSayisi);
        Assert.assertEquals(3,iciDoluHucreSayisi);

    }
}