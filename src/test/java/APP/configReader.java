package APP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    public static Properties prop;
    public static Properties loadConfig() throws IOException {
        try {
            FileInputStream fis = new FileInputStream("src/test/config/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
return prop;
    }

}
