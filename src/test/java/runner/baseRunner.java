package runner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class baseRunner
{
    public static void main(String[] args) throws IOException, BiffException {
        System.out.println("Reading Excel for testNg Preparation");

        // Get the current working directory
        String currentDirectory = System.getProperty("user.dir");

        // Append the Excel file name to the current directory
        String excelFilePath = currentDirectory + File.separator + "TestCaseRunner.xls";

        File inputWorkbook = new File(excelFilePath);

        Workbook workbook = Workbook.getWorkbook(inputWorkbook);
        Sheet sheet = workbook.getSheet(0); // Assuming you want to read the first sheet

        List<XmlSuite> suites = new ArrayList<>();

        // Create TestNG suite
        XmlSuite suite = new XmlSuite();
        suite.setName("Test Suite");


        int rows = sheet.getRows();
        for (int i = 1; i < rows; i++) {
            Cell testClassCell = sheet.getCell(1, i); // Assuming test class name is in column 1
            Cell executionCell = sheet.getCell(2, i); // Assuming execution status is in column 3
            Cell executionTypeCell = sheet.getCell(3, i); // Assuming execution type is in column 4

            String executionStatus = executionCell.getContents();
            String testClass = testClassCell.getContents();
            String executionType = executionTypeCell.getContents();

            if (executionStatus.equalsIgnoreCase("Yes"))
            {
                XmlTest test = new XmlTest(suite);
                test.setName("Test - " + testClass);
                test.addParameter("TestClass", testClass);

                XmlClass xmlClass = new XmlClass(testClass);
                List<XmlClass> classes = new ArrayList<>();
                classes.add(xmlClass);
                test.setXmlClasses(classes);

                if (executionType.equalsIgnoreCase("Parallel")) {
                    test.setParallel(XmlSuite.ParallelMode.TESTS);
                }
/*
                suite.addTest(test);
                */
            }
        }

        suites.add(suite);

        // Run TestNG
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);

        // Convert the suite object to XML representation
        String suiteXml = suite.toXml();

        // Print the XML representation of the TestNG suite
        System.out.println("Generated TestNG Suite:");
        System.out.println(suiteXml);

        //Run Suit
        System.out.println("*******************************************");
        testNG.run();

        workbook.close();

    }
}
