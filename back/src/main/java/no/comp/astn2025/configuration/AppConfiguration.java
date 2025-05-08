package no.comp.astn2025.configuration;

import java.io.IOException;
import java.util.Properties;

public class AppConfiguration {
    private static final String CONFIG_FILE_NAME = "application.properties";
    public static final String CONNECTION_POOL_SIZE = "connection-pool.size";
    public static final String CONNECTION_POOL_DB_URL = "connection-pool.db-url";
    public static final String CONNECTION_POOL_USERNAME = "connection-pool.username";
    public static final String CONNECTION_POOL_PASSWORD = "connection-pool.password";
    public static final String CONNECTION_POOL_DRIVER_CLASS = "connection-pool.driver-class-name";
    public static final String DAO_USER_DAO_IMPL = "dao.user-dao-impl";
    private static AppConfiguration INSTANCE;
    private Properties properties;

    private AppConfiguration() {
        this.properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
        } catch (IOException exc) { throw new RuntimeException(exc); }
    }

    public static AppConfiguration getInstance() {
        if (INSTANCE == null) {
            synchronized (AppConfiguration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppConfiguration();
                }
            }
        }

        return INSTANCE;
    }

    public String getProperty(String property) {
        return this.properties.getProperty(property);
    }
}
