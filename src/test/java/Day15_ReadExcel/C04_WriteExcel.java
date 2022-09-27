package Day15_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {


    @Test
    public void test1() throws IOException {
        //Yeni bir Class olusturalim WriteExcel
        //Yeni bir test method olusturalim writeExcelTest()
        //Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        //5.hucreye yeni bir cell olusturalim
        //Olusturdugumuz hucreye ?Nufus? yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        //2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1.500.000");
        //10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250.000");
        //15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54.000");
        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        // Excel dosyam?za veri giri?i yapt?ktan sonra dosyay? ak??a ald???m?z gibi sonland?rmam?z gerekir.
        // Sonras?nda da workbook objemize kay?t etmemiz gerekir
        workbook.write(fos); // Write methodu ile sonland?rd???m?z i?lemi workbook'a yazd?rd?k
        //Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();
    }
}