package Day15_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_Delete_Excel {

    @Test
    public void name() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)

        //-Row objesi olusturun sheet.getRow(3)
        //-Cell objesi olusturun row.getCell(3)
        //-3. Sat?r 3. Cell'deki veriyi silelim
        //-Silindi?ini test edin


    }
}