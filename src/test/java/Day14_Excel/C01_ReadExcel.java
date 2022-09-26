package Day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test1() throws IOException {





        //- Dosya yolunu bir String degiskene atayalim
        String ExcelDosyaYolu = "src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(ExcelDosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");

        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);

        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);

        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData = "Cezayir";
        String actualData=cell.getStringCellValue();
        Assert.assertEquals(actualData,expectedData);

        System.out.println(cell);

        // deneme yol çalışması
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\Terimler.txt";
        String arananDosyaYolu=farkliKisim+ortakKisim;

        System.out.println(farkliKisim);
        System.out.println(arananDosyaYolu);
        // deneme yol çalışması
    }
}
