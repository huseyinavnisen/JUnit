package Practise;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_Practise extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {

        //Verify that we have pom.xml file in our project => please try in 4 min s
        String dosyaYolu = "pom.xml";


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
