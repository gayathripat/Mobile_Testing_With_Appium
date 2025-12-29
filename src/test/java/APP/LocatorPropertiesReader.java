package APP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LocatorPropertiesReader
{
    public static Properties LoadLocator(String fileName){
         Properties prop=new Properties();
        try{
            FileInputStream fis=new FileInputStream("src/test/java/Pages/"+ fileName + ".properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("locator file not found"+fileName+" .properties");
        }
        return prop;
    }
}
