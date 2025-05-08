package no.comp.astn2025.dao;

import no.comp.astn2025.configuration.AppConfiguration;

public class DaoFactory {
    private static DaoFactory INSTANCE;
    private static final AppConfiguration APPLICATION_CONFIG = AppConfiguration.getInstance();

    private final UserDao USER_DAO_INSTANCE;

    private DaoFactory() {

        try {
            String userDaoImplClassname = APPLICATION_CONFIG.getProperty(AppConfiguration.DAO_USER_DAO_IMPL);
            Class<?> instance = Class.forName(userDaoImplClassname);
            USER_DAO_INSTANCE = (UserDao)instance.getConstructors()[0].newInstance();
        } catch (Exception exc) { throw new RuntimeException(exc); }
    }

    public static DaoFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (DaoFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DaoFactory();
                }
            }
        }

        return INSTANCE;
    }

    public UserDao getUserDao() {
        return this.USER_DAO_INSTANCE;
    }
}
