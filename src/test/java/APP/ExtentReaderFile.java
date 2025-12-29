package APP;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExtentReaderFile {
    public static Properties load() throws IOException {

    Properties prop = new Properties();
    try
            (InputStream is = ExtentReaderFile.class.getClassLoader().getResourceAsStream("extendReport.properties"))
    {

    if(is==null)
    {
        throw new RuntimeException("extentReport.properties not found");
    }
    prop.load(is);
    }
    catch(Exception e){
    e.printStackTrace();
    throw new RuntimeException(e);
    }
    return prop;
    }}

