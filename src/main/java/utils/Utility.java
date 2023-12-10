package utils;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
public class Utility {
//a
    public static Properties p;
    public static WebDriver driver;

    public Utility(WebDriver driver){
        Utility.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public static String getDataFromPropertyFile(String url) throws IOException {

        FileInputStream file = null;
        try {
            file = new FileInputStream("configuration\\config.properties");
        } catch (FileNotFoundException e) {

            System.out.println(e.getMessage());
        }

        p = new Properties();
        p.load(file);

        String value1;
        value1 = p.getProperty(url);
        return value1;
    }

    public static void captureScreenshot(WebDriver driver, int testID) throws IOException {

        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH mm ss");
        LocalDateTime now = LocalDateTime.now();

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("test-output//Screenshot//Test-" + testID + " " + date.format(now) + ".jpeg");
        FileHandler.copy(source, dest);
    }

    public static String getTD(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\ramko\\IdeaProjects\\SSCRegistration\\TestData\\Data.xlsx");

        Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
        String value;
        value = sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
        return value;
    }

    public static String getTDNumeric(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\ramko\\IdeaProjects\\SSCRegistration\\TestData\\Data.xlsx");

        Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
        double numValue;
        numValue = sh.getRow(RowIndex).getCell(CellIndex).getNumericCellValue();
        return String.valueOf(numValue);
        //To take Numeric value like Mobile No
    }

}
