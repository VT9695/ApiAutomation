package api.com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helper {
    public static final String commonFilePath = System.getProperty("user.dir") + "/src/test/common.properties";

    public static String propertyReader(String key) {
        String value = null;

        try (InputStream input = new FileInputStream(commonFilePath)) {
            Properties prop = new Properties();
            prop.load(input);
            value = prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return value;
    }
    
    public static String getUri() throws IOException, org.json.simple.parser.ParseException {
   	 String uri =Helper.propertyReader("qaBaseUrl") + ReadTestData.getTestData("endPointUrl");
   		return uri;
   }
    
}
