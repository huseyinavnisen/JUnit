package Day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcel() throws IOException {

    // Belirtilen Sat?rNo ve sutunNo de?erlerini baz al?p o hücredeki de?eri yazd?r?n

        int satir=12;
        int sutun=2;

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook.
                getSheet("Sayfa1")
                .getRow(satir-1)
                .getCell(sutun-1)
                .toString();
        System.out.println(actualData);

        // sonucun konsolda yazanla ayn? oldu?unu do?rulay?n
        String expectedData="Baku";
        Assert.assertEquals(actualData,expectedData);

    }
}
