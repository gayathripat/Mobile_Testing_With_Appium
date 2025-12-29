package Utility;

import APP.ExtentReaderFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ExtentManager {

    private static ExtentReports extent;
    public synchronized static ExtentReports getExtent() throws IOException {
        if(extent==null){
            Properties prop=ExtentReaderFile.load();

            String path=prop.getProperty("extent.report.path");
            new File(path).getParentFile().mkdir();

            ExtentSparkReporter spark=new ExtentSparkReporter(path);
            spark.config().setReportName(prop.getProperty("extent.report.name"));
            spark.config().setDocumentTitle(prop.getProperty("extent.document.title"));

            extent=new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("platform",prop.getProperty("System.platform"));
            extent.setSystemInfo("Automation",prop.getProperty("System.automation"));
            extent.setSystemInfo("language",prop.getProperty("System.language"));


        }
        return null;
    }
}
