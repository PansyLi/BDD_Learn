package config;

import java.io.*;
import java.util.Properties;

public class TestConfig {
    private static TestConfig testConfig;
    private static Properties properties;
    private static String pageUrl;

    public static TestConfig getIntance() throws IOException {
        if(TestConfig.testConfig == null){
            System.out.println("********testconfig is null!");
            TestConfig.properties = new Properties();
            populateCommonDetails();
            TestConfig.testConfig = new TestConfig();
        }
        return  TestConfig.testConfig;
    }

    public static String valueFor(final String keyName) throws IOException {
        return getIntance().getProperty(keyName);
    }
    private static void populateCommonDetails() throws IOException {
        String commonPropertiesFilePath = "src/test/resources/config.properties";
        loadPropertiesFormFile(commonPropertiesFilePath);
    }
    private static void loadPropertiesFormFile(String filePath) throws IOException {
        File propFile = new File(filePath);
        if (!propFile.exists()){
            throw new FileNotFoundException(String.format("No properties file found at:", filePath));
        }
        InputStream input = new FileInputStream(filePath);
        properties.load(input);
        input.close();
    }
    public static boolean hasProperty(final String keyName) throws IOException {
        return getIntance().propertyExists(keyName);
    }
    private Boolean propertyExists(final String keyName){
        return properties.getProperty(keyName) != null?true:false;

    }
    public static String getProperty(final String keyName) {
        String value = properties.getProperty(keyName);
        if (value == null){
            throw new Error(String.format("key %s not configured for environment", keyName));
        }
        return value;
    }
}
