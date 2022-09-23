package Day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_File_Exists {
    @Test
    public void name() {
       // System.out.println(System.getProperty("user.dir")); // C:\Users\Hüseyin\IdeaProjects\com.Batch81Junit
       // System.out.println(System.getProperty("user.home")); // C:\Users\Hüseyin

        // indirilen dosyaya Shift + sağ tıklayarak "YOL OLARAK KOPYALA" diyerek yolunu aldık
        // "C:\\Users\\Hüseyin\\Desktop\\text.txt";

        String dosyaYolu="C:\\Users\\Hüseyin\\Desktop\\text.txt";
        // System.out.println(Files.exists(Paths.get(dosyaYolu))); // TRUE döndürür
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // "C:\Users\Hüseyin\Downloads\Se4 yenilikler.pdf"

    }


}
