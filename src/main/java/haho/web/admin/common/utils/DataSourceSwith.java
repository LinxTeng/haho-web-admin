package haho.web.admin.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import haho.web.admin.common.exception.DataSourceSwithExcepion;

@Component
public class DataSourceSwith implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static ThreadLocal<JdbcTemplate> localJdbc = new ThreadLocal<>();

    public static final String DEVA = "dev-a";

    public static final String DEVB = "dev-b";

    public static final String TESTA = "test-a";

    public static final String TESTB = "test-b";

    public static final String YUFABU = "yufabu";

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        DataSourceSwith.applicationContext = applicationContext;
    }

    public static JdbcTemplate getJdbcTemplate() throws DataSourceSwithExcepion {
        // 默认使用deva
        if (localJdbc.get() == null) {
            throw new DataSourceSwithExcepion("未拿到环境变量");
        }
        return localJdbc.get();
    }

    // dev-a
    public static void switchToDeva() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("devaJdbcTemplate"));
    }

    // dev-b
    public static void switchToDevb() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("devbJdbcTemplate"));
    }

    // test-a
    public static void switchToTesta() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("testaJdbcTemplate"));
    }

    // test-b
    public static void switchToTestb() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("testbJdbcTemplate"));
    }

    // yufabu
    public static void switchToYufabu() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("yufabuJdbcTemplate"));
    }

    public static void swithenv(String env) throws DataSourceSwithExcepion {
        switch (env) {
            case TESTA:
                DataSourceSwith.switchToTesta();
                break;
            case TESTB:
                DataSourceSwith.switchToTestb();
                break;
            case DEVA:
                DataSourceSwith.switchToDeva();
                break;
            case DEVB:
                DataSourceSwith.switchToDevb();
                break;
            case YUFABU:
                DataSourceSwith.switchToYufabu();
                break;
            default:
                throw new DataSourceSwithExcepion("切换环境时找不到对应的环境");
        }
    }
}
